package com.klym.kbpm.shared.service;

import java.util.HashMap;
import java.util.Map;

import org.kie.kogito.internal.process.runtime.KogitoWorkItem;
import org.kie.kogito.internal.process.runtime.KogitoWorkItemHandler;
import org.kie.kogito.internal.process.runtime.KogitoWorkItemManager;

import com.klym.kbpm.shared.model.RequestWrapper;
import com.klym.kbpm.shared.model.ResponseWrapper;

public abstract class BaseWorkItemHandler implements KogitoWorkItemHandler {

    protected abstract ResponseWrapper invokeRestService(RequestWrapper requestWrapper);

    @Override
    public void abortWorkItem(KogitoWorkItem arg0, KogitoWorkItemManager arg1) {
        System.err.println("Error happened in the custom work item definition.");
    }

    @Override
    public void executeWorkItem(KogitoWorkItem workItem, KogitoWorkItemManager manager) {
        // i.e. url can be https://randomuser.me/api/
        RequestWrapper request = (RequestWrapper) workItem.getParameters().get("request");
        ResponseWrapper answer = invokeRestService(request);

        Map<String, Object> results = new HashMap<String, Object>();
        results.put("result", answer);
        // Don’t forget to finish the work item otherwise the process
        // will be active infinitely and never will pass the flow
        // to the next node.
        manager.completeWorkItem(workItem.getStringId(), results);
    }

}
