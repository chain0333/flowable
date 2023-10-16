package com.flw.controller;

import com.flw.model.TaskDetails;
import com.flw.model.TaskInfo;
import com.flw.service.TaskOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flowable/rest/task/v1")
public class TaskController {

    @Autowired
    TaskOperationsService taskOperationsService;

    @GetMapping("/getUnAssignedTasks")
    public List<TaskDetails> getUnAssignedTasks() {
        List<TaskDetails> taskList = null;
        try {
            taskList = taskOperationsService.getUnAssignedTasks();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taskList;
    }

    @PostMapping("/completeTask")
    public void completeTask(@RequestBody TaskInfo taskInfo) {
        taskOperationsService.completeTask(taskInfo);
    }

    @PostMapping("/claimTask")
    public void claimTask(String taskId, String userId) {
        taskOperationsService.claimTask(taskId, userId);
    }

    @GetMapping("/getTasksByUser")
    public List<TaskDetails> getTasksByAssignee(String assignee) {
        List<TaskDetails> taskList = null;
        try {
            taskList = taskOperationsService.getTasksByAssignee(assignee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taskList;
    }

    @GetMapping("/getTasksByVariable")
    public List<TaskDetails> getTasksByTaskVariable(String varialeName, String variableValue) {
        List<TaskDetails> taskList = null;
        try {
            taskList = taskOperationsService.getTasksByTaskVariable(varialeName, variableValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taskList;
    }

    @GetMapping("/getAssignedTasks")
    public List<TaskDetails> getAllAssignedTasks() {
        List<TaskDetails> taskList = null;
        try {
            taskList = taskOperationsService.getAllAssignedTasks();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taskList;
    }

    @GetMapping("/getAllTasks")
    public List<TaskDetails> getAllTasks() {
        List<TaskDetails> taskList = null;
        try {
            taskList = taskOperationsService.getAllAssignedTasks();
            taskList.addAll(taskOperationsService.getUnAssignedTasks());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taskList;
    }
}
