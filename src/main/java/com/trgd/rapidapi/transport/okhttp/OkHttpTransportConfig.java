package com.trgd.rapidapi.transport.okhttp;

import com.trgd.rapidapi.core.TransportConfig;

final public class OkHttpTransportConfig extends TransportConfig {
    private long readTimeout = 0;
    private long connectTimeout = 0;
    private String cacheDir = "";
    private long cacheMaxSizeMiB = 0;

    public void setReadTimeout(long readTimeout) {
        if (readTimeout < 0) {
            readTimeout = 0;
        }
        this.readTimeout = readTimeout;
    }

    public long getReadTimeout() {
        return this.readTimeout;
    }

    public void setConnectTimeout(long connectTimeout) {
        if (connectTimeout < 0) {
            connectTimeout = 0;
        }
        this.connectTimeout = connectTimeout;
    }

    public long getConnectTimeout() {
        return this.connectTimeout;
    }

    public void setCacheDir(String cacheDir) {
        this.cacheDir = cacheDir;
    }

    public String getCacheDir() {
        return this.cacheDir;
    }

    public void setCacheMaxSizeMiB(long maxSizeMiB) {
        this.cacheMaxSizeMiB = maxSizeMiB;
    }

    public long getCacheMaxSizeMiB() {
        return this.cacheMaxSizeMiB;
    }
}
