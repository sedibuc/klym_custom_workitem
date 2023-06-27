package com.klym.kbpm.model;

import java.io.Serializable;

import com.klym.kbpm.shared.model.ResponseWrapper;

public class BpmAnswer implements Serializable {
    private ResponseWrapper responseWrapper;
    private String answer;
    
    public BpmAnswer() {
    }

    public ResponseWrapper getResponseWrapper() {
        return responseWrapper;
    }
    public void setResponseWrapper(ResponseWrapper responseWrapper) {
        this.responseWrapper = responseWrapper;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
}
