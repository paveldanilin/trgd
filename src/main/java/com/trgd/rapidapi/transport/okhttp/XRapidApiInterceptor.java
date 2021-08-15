package com.trgd.rapidapi.transport.okhttp;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class XRapidApiInterceptor implements Interceptor {

    private final String rapidApiKey;
    private final String rapidApiHost;

    public XRapidApiInterceptor(String rapidApiKey, String rapidApiHost) {
        this.rapidApiKey = rapidApiKey;
        this.rapidApiHost = rapidApiHost;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request requestWithUserAgent = originalRequest
                .newBuilder()
                .header("x-rapidapi-key", this.rapidApiKey)
                .header("x-rapidapi-host", this.rapidApiHost)
                .build();

        return chain.proceed(requestWithUserAgent);
    }
}
