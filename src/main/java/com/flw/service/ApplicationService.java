package com.flw.service;

import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ApplicationService {

    public ProcessInstance initiateApprovalWorkflow(Map<String, Object> objectMap, String processKey);
}
