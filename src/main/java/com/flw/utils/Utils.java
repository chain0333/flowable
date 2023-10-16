package com.flw.utils;

import com.flw.model.TaskDetails;
import org.flowable.task.api.Task;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Utils {

    public TaskDetails taskToTaskDetailsMapper(Task task, Map<String, Object> variablesMap) {
        TaskDetails taskDetails = new TaskDetails();
        taskDetails.setId(task.getId());
        taskDetails.setAssignee(task.getAssignee());
        taskDetails.setName(task.getName());
        taskDetails.setProcessInstanceId(task.getProcessInstanceId());
        taskDetails.setCreationTime(task.getCreateTime());
        taskDetails.setSuspended(task.isSuspended());
        taskDetails.setCaseVariables(variablesMap);
        return taskDetails;
    }
}

