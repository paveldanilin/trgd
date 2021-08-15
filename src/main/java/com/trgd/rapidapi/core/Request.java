package com.trgd.rapidapi.core;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

final public class Request implements RapidApiRequest {
    private RapidApiMediaType mediaType;
    private RapidApiMethod httpMethod;
    private RapidApiProtocol protocol;
    private String host;
    private int port;
    private String path;
    private Map<String, String> headers;
    private Map<String, String> queryParameters;
    private String body;
    private Map<String, String> bodyVariables;
    private Map<String, String> pathParameters;

    private Request() {}

    @Override
    public RapidApiMediaType getMediaType() {
        return this.mediaType;
    }

    @Override
    public RapidApiMethod getMethod() {
        return this.httpMethod;
    }

    @Override
    public RapidApiProtocol getProtocol() {
        return this.protocol;
    }

    @Override
    public String getHost() {
        return this.host;
    }

    @Override
    public int getPort() {
        return this.port;
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override
    public Map<String, String> getQueryParameters() {
        return this.queryParameters;
    }

    @Override
    public Map<String, String> getPathParameters() {
        return this.pathParameters;
    }

    @Override
    public String getBody() {
        return this.body;
    }

    @Override
    public Map<String, String> getBodyVariables() {
        return this.bodyVariables;
    }

    @Override
    public String getUri() {
        StringBuilder sb = new StringBuilder();

        // http://rapid.api.com/endpoint?a=1
        // => ^
        sb.append(this.getProtocol().toString());
        sb.append("://");

        // http://rapid.api.com/endpoint?a=1
        // ============> ^
        sb.append(this.getHost());

        // http://rapid.api.com:8000/endpoint?a=1
        // ====================> ^
        if (this.getPort() != 80 && this.getPort() != 0) {
            sb.append(":");
            sb.append(this.getPort());
        }

        // http://rapid.api.com/endpoint?a=1
        // ======================> ^
        if (this.pathParameters.size() == 0) {
            sb.append(this.getPath());
        } else {
            String path = this.getPath();
            for (Map.Entry<String, String> entry: this.pathParameters.entrySet()) {
                path = path.replaceAll("\\{" + entry.getKey() + "\\}", entry.getValue());
            }
            sb.append(path);
        }

        // http://rapid.api.com/endpoint?a=1
        // ============================>  ^
        if (this.queryParameters.size() > 0) {
            int entryIdx = 1;
            sb.append("?");
            for (Map.Entry<String, String> entry: this.queryParameters.entrySet()) {
                sb.append(entry.getKey());
                sb.append("=");
                try {
                    sb.append(URLEncoder.encode(entry.getValue(), String.valueOf(StandardCharsets.UTF_8)));
                } catch (UnsupportedEncodingException unsupportedEncodingException) {
                    sb.append(entry.getValue());
                }
                entryIdx++;
                if (entryIdx < this.queryParameters.size()) {
                    sb.append("&");
                }
            }
        }

        return sb.toString();
    }

    public static class Builder {
        private RapidApiMediaType nestedMediaType;
        private RapidApiMethod nestedHttpMethod;
        private RapidApiProtocol nestedProtocol;
        private String nestedHost;
        private int nestedPort;
        private String nestedPath;
        private Map<String, String> nestedHeaders;
        private Map<String, String> nestedQueryParameters;
        private String nestedBody;
        private Map<String, String> nestedBodyVariables;
        private Map<String, String> nestedPathParameters;

        public Builder mediaType(RapidApiMediaType mediaType) {
            this.nestedMediaType = mediaType;
            return this;
        }

        public Builder httpMethod(RapidApiMethod httpMethod) {
            this.nestedHttpMethod = httpMethod;
            return this;
        }

        public Builder protocol(RapidApiProtocol protocol) {
            this.nestedProtocol = protocol;
            return this;
        }

        public Builder host(String host) {
            this.nestedHost = host;
            return this;
        }

        public Builder port(int port) {
            this.nestedPort = port;
            return this;
        }

        public Builder path(String path) {
            this.nestedPath = path;
            return this;
        }

        public Builder body(String body) {
            this.nestedBody = body;
            return this;
        }

        public Builder headers(Map<String, String> headers) {
            this.nestedHeaders = headers;
            return this;
        }

        public Builder queryParameters(Map<String, String> queryParameters) {
            this.nestedQueryParameters = queryParameters;
            return this;
        }

        public Builder bodyVariables(Map<String, String> bodyVariables) {
            this.nestedBodyVariables = bodyVariables;
            return this;
        }

        public Builder pathParameters(Map<String, String> pathParameters) {
            this.nestedPathParameters = pathParameters;
            return this;
        }

        public Request build() {
            Request req = new Request();
            req.mediaType = this.nestedMediaType;
            req.httpMethod = this.nestedHttpMethod;
            req.protocol = this.nestedProtocol;
            req.host = this.nestedHost;
            req.port = this.nestedPort;
            req.path = this.nestedPath;
            req.body = this.nestedBody;

            if (this.nestedHeaders == null) {
                req.headers = new HashMap<>();
            } else {
                req.headers = this.nestedHeaders;
            }

            if (this.nestedQueryParameters == null) {
                req.queryParameters = new HashMap<>();
            } else {
                req.queryParameters = this.nestedQueryParameters;
            }

            if (this.nestedBodyVariables == null) {
                req.bodyVariables = new HashMap<>();
            } else {
                req.bodyVariables = this.nestedBodyVariables;
            }

            if (this.nestedPathParameters == null) {
                req.pathParameters = new HashMap<>();
            } else {
                req.pathParameters = this.nestedPathParameters;
            }

            return req;
        }
    }
}
