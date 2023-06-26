package com.klym.kbpm.shared.service;

import com.klym.kbpm.shared.exception.KbpmException;
import com.klym.kbpm.shared.http.RestClient;
import com.klym.kbpm.shared.model.RequestWrapper;
import com.klym.kbpm.shared.model.ResponseWrapper;

public class GetWorkItemHandler extends BaseWorkItemHandler {

    public static void main(String[] args) {
        RequestWrapper wrapper = new RequestWrapper();
        wrapper.setPath("https://randomuser.me/api/");
        System.out.println(new GetWorkItemHandler().invokeRestService(wrapper));
    }

    protected ResponseWrapper invokeRestService(RequestWrapper requestWrapper) {
        
        ResponseWrapper cr = new ResponseWrapper();
        try {
            System.out.println(requestWrapper);
            RestClient.executeRequest(requestWrapper.getPath(), cr);
        } catch (KbpmException ex) {
            ex.printStackTrace();
            cr.setResponseCode(ResponseWrapper.ERROR);
            cr.setErrorMessage(ex.getKogitoErrorMessage());
        }
        return cr;
    }

}
