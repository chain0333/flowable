package com.flw.model;

import java.util.Map;

public class TaskInfo {
    private String taskId;
    private Map<String, Object> taskVariables;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Map<String, Object> getTaskVariables() {
        return taskVariables;
    }

    public void setTaskVariables(Map<String, Object> taskVariables) {
        this.taskVariables = taskVariables;
    }
}
