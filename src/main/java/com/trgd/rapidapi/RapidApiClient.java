package com.trgd.rapidapi;

import com.trgd.rapidapi.core.RapidApiProtocol;
import com.trgd.rapidapi.core.RapidApiTransport;
import com.trgd.rapidapi.core.Request;

public abstract class RapidApiClient {
    private final RapidApiTransport transport;
    private final String apiHost;

    public RapidApiClient(String apiHost, RapidApiTransport transport) {
        this.apiHost = apiHost;
        this.transport = transport;
    }

    protected RapidApiTransport getTransport() {
        return this.transport;
    }

    protected Request.Builder getRequestBuilder() {
        return new Request.Builder().protocol(RapidApiProtocol.HTTPS).host(this.apiHost);
    }
}
