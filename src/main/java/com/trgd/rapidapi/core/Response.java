package com.trgd.rapidapi.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

final public class Response implements RapidApiResponse {
    private final String rawResponse;
    private DocumentContext documentContext;

    public Response(String rawResponse) {
        this.rawResponse = rawResponse;
    }

    public String getRawResponse() {
        return this.rawResponse;
    }

    public boolean isEmpty() {
        return this.rawResponse == null || this.rawResponse.trim().length() == 0;
    }

    public <T> T getFieldValue(String fieldJsonPath, Class<T> type) throws RuntimeException {
        return this.getDocumentContext().read(fieldJsonPath, type);
    }

    private DocumentContext getDocumentContext() throws RuntimeException {
        if (this.isEmpty()) {
            throw new RuntimeException("The response body is empty");
        }
        if (this.documentContext == null) {
            ObjectMapper objectMapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Configuration configuration = new Configuration.ConfigurationBuilder()
                    .jsonProvider(new JacksonJsonProvider())
                    .mappingProvider(new JacksonMappingProvider(objectMapper))
                    .build();
            this.documentContext = JsonPath.using(configuration).parse(this.getRawResponse());
        }
        return this.documentContext;
    }
}
