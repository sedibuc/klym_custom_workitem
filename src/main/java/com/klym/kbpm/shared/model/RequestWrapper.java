package com.klym.kbpm.shared.model;

import java.io.Serializable;
import java.util.Map;

public class RequestWrapper implements Serializable {
    private String path;
    private Map<String, String> queryParams;
    private Map<String, String> headers;

    
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public Map<String, String> getQueryParams() {
        return queryParams;
    }
    public void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }
    public Map<String, String> getHeaders() {
        return headers;
    }
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
    
    @Override
    public String toString() {
        return "RequestWrapper [path=" + path + "]";
    }
    
}
