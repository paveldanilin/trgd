package com.trgd.rapidapi.core;

public interface RapidApiResponse {
    String getRawResponse();
    boolean isEmpty();
    <T> T getFieldValue(String fieldJsonPath, Class<T> type) throws RuntimeException;
}
