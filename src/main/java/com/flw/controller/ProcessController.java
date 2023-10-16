package com.flw.controller;

import com.flw.service.ApplicationService;
import org.flowable.common.engine.api.FlowableIllegalArgumentException;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/flowable/rest/process/v1")
public class ProcessController {

    @Autowired
    ApplicationService applicationService;

    @PostMapping("/createFlowableProcess")
    public String createProcessInstance(@RequestBody Map<String, Object> objectMap) {
        String ProcessInstanceId = null;
        if (objectMap != null) {
            if (objectMap.get("processKey") != null) {
                String processKey = (String) objectMap.get("processKey");
                ProcessInstance processInstance = applicationService.initiateApprovalWorkflow(objectMap, processKey);
                ProcessInstanceId = processInstance.getProcessInstanceId();
            } else
                throw new FlowableIllegalArgumentException("Invalid Process Key");
        }
        return ProcessInstanceId;
    }

    @GetMapping("/healthCheck")
    public String healthCheckAPI() {
        return "I am up and running";
    }

}
