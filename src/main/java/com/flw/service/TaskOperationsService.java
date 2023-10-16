package com.flw.service;

import com.flw.model.TaskDetails;
import com.flw.model.TaskInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskOperationsService {
    public List<TaskDetails> getUnAssignedTasks();

    public void completeTask(TaskInfo taskInfo);

    public void claimTask(String taskId, String userId);

    public List<TaskDetails> getTasksByAssignee(String assignee);

    public List<TaskDetails> getTasksByTaskVariable(String varialeName, String variableValue);

    public List<TaskDetails> getAllAssignedTasks();


}
