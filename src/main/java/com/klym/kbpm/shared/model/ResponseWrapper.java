package com.klym.kbpm.shared.model;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

import com.jayway.jsonpath.JsonPath;  


public class ResponseWrapper implements Serializable {

    public static int OK = 1;
    public static int ERROR = -1;

    private int responseCode;
    private Map<String, Object> data;
    private JSONObject jsonData;
    private String jsonString;
    private String errorMessage;

    public ResponseWrapper() {
        this.data = new TreeMap<>();
        responseCode = ResponseWrapper.OK;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public JSONObject getJsonData() {
        return jsonData;
    }

    public void setJsonData(JSONObject jsonData) {
        this.jsonData = jsonData;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }

    public String getJsonString() {
        return jsonString;
    }

    public Object getValue(String path) {
        return JsonPath.read(jsonString, path);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "CustomResult [responseCode=" + responseCode + ", data=" + data + "]";
    }

    
}
