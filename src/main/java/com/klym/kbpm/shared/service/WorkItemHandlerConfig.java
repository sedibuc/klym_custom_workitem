package com.klym.kbpm.shared.service;

import javax.enterprise.context.ApplicationScoped;
import org.kie.kogito.process.impl.DefaultWorkItemHandlerConfig;

@ApplicationScoped
public class WorkItemHandlerConfig extends DefaultWorkItemHandlerConfig {
    {
        register("GetWorkItemHandler", new GetWorkItemHandler());
        register("ListWorkItemHandler", new GetWorkItemHandler());
    }
}
