package com.flw.service;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    RepositoryService repositoryService;


    @Override
    public ProcessInstance initiateApprovalWorkflow(Map<String, Object> objectMap, String processKey) {
        ProcessInstance processInstance = null;
        try {
            processInstance = runtimeService.startProcessInstanceByKey(processKey, objectMap);
            System.out.println("Instance created with process instance ID: " + processInstance.getProcessInstanceId());
        } catch (Exception e) {
            System.out.println("Instance creation failed with:");
            e.printStackTrace();
        }
        return processInstance;
    }
}
