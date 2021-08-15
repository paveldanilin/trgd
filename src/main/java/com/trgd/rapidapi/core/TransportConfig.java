package com.trgd.rapidapi.core;

public abstract class TransportConfig {
    private String rapidApiKey;
    private String rapidApiHost;

    public String getRapidApiKey() {
        return rapidApiKey;
    }

    public void setRapidApiKey(String rapidApiKey) {
        this.rapidApiKey = rapidApiKey;
    }

    public String getRapidApiHost() {
        return rapidApiHost;
    }

    public void setRapidApiHost(String rapidApiHost) {
        this.rapidApiHost = rapidApiHost;
    }
}
