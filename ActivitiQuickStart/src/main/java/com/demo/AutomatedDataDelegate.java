package com.demo;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import java.util.Date;

/**
 * @Author:
 * @Description:
 * @Data:Created in 14:25 2018/8/27
 */
public class AutomatedDataDelegate implements JavaDelegate {


    @Override
    public void execute(DelegateExecution delegateExecution) {
        Date now = new Date();
        delegateExecution.setVariable("autoWelcomeTime",now);
        System.out.println("Faux call to backend for [" + delegateExecution.getVariable("fullName") + "]");
    }
}
