package com.trgd.rapidapi.core;

import java.util.Map;

public interface RapidApiRequest {
    RapidApiMediaType getMediaType();
    RapidApiMethod getMethod();
    RapidApiProtocol getProtocol();
    String getHost();
    int getPort();
    String getPath();
    Map<String, String> getHeaders();
    Map<String, String> getQueryParameters();
    Map<String, String> getPathParameters();
    String getBody();
    Map<String, String> getBodyVariables();
    String getUri();
}
