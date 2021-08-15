package com.trgd.rapidapi.transport.okhttp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trgd.rapidapi.core.*;
import com.trgd.rapidapi.template.TemplateEngine;
import okhttp3.*;
import okhttp3.Request;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OkHttpTransport implements RapidApiTransport {
    private final OkHttpTransportConfig config;
    private OkHttpClient httpClient;
    private final TemplateEngine templateEngine;
    private final ObjectMapper objectMapper;

    public OkHttpTransport(OkHttpTransportConfig config) {
        this.config = config;
        this.templateEngine = null;
        this.objectMapper = new ObjectMapper();
    }

    public OkHttpTransport(OkHttpTransportConfig config, TemplateEngine templateEngine) {
        this.config = config;
        this.templateEngine = templateEngine;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public RapidApiResponse call(RapidApiRequest rapidApiRequest) throws IOException {

        Request.Builder requestBuilder = new Request.Builder().url(rapidApiRequest.getUri());

        if (rapidApiRequest.getMethod() == RapidApiMethod.POST) {
            requestBuilder = requestBuilder.post(this.createRequestBody(rapidApiRequest));
        }

        Call call = this.getHttpClient().newCall(requestBuilder.build());

        okhttp3.Response response = call.execute();

        return new com.trgd.rapidapi.core.Response(response.body().string());
    }

    private RequestBody createRequestBody(RapidApiRequest rapidApiRequest) throws IOException {

        // Form
        if (rapidApiRequest.getMediaType() == RapidApiMediaType.FORM) {
            return this.createFormRequestBody(rapidApiRequest);
        }

        // JSON
        if (rapidApiRequest.getMediaType() == RapidApiMediaType.JSON) {
            return this.createJsonRequestBody(rapidApiRequest);
        }

        return new FormBody.Builder().build();
    }

    private RequestBody createFormRequestBody(RapidApiRequest rapidApiRequest) {
        FormBody.Builder formBuilder = new FormBody.Builder();
        for (Map.Entry<String, String> entry: rapidApiRequest.getBodyVariables().entrySet()) {
            formBuilder = formBuilder.add(entry.getKey(), entry.getValue());
        }
        return formBuilder.build();
    }

    private RequestBody createJsonRequestBody(RapidApiRequest rapidApiRequest) throws IOException {
        String jsonBody = "";

        if (rapidApiRequest.getBody().trim().length() == 0) {
            try {
                jsonBody = this.objectMapper.writeValueAsString(rapidApiRequest.getBodyVariables());
            } catch (JsonProcessingException e) {
                jsonBody = "";
            }
        } else if(this.templateEngine != null) {
            jsonBody = this.templateEngine.interpolate(rapidApiRequest.getBody(), rapidApiRequest.getBodyVariables());
        }

        return RequestBody.create(MediaType.parse("application/json"), jsonBody);
    }

    private OkHttpClient getHttpClient() throws RuntimeException {
        if (null == this.httpClient) {
            this.httpClient = this.createHttpClient();
        }
        return this.httpClient;
    }

    private OkHttpClient createHttpClient() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .addInterceptor(new XRapidApiInterceptor(this.config.getRapidApiKey(), this.config.getRapidApiHost()));

        if (this.config.getReadTimeout() > 0) {
            clientBuilder.readTimeout(this.config.getReadTimeout(), TimeUnit.SECONDS);
        }

        if (this.config.getConnectTimeout() > 0) {
            clientBuilder.connectTimeout(this.config.getConnectTimeout(), TimeUnit.SECONDS);
        }

        if (this.config.getCacheDir().length() > 0) {
            File cacheDir = new File(this.config.getCacheDir());
            if (!cacheDir.exists()) {
                throw new RuntimeException("Cache directory not found");
            }
            long cacheSize = this.config.getCacheMaxSizeMiB();
            if (cacheSize < 0) {
                cacheSize = 10L;
            }
            cacheSize = cacheSize * 1024L * 1024L; // MiB
            clientBuilder.cache(new Cache(cacheDir, cacheSize));
        }

        return clientBuilder.build();
    }
}
