package com.klym.kbpm.service;

import javax.enterprise.context.ApplicationScoped;

import com.klym.kbpm.model.BpmAnswer;

@ApplicationScoped
public class ProcessInit {

    public BpmAnswer init() {
        return new BpmAnswer();
    }
}