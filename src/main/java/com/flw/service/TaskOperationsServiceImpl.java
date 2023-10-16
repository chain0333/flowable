package com.flw.service;

import com.flw.model.TaskDetails;
import com.flw.model.TaskInfo;
import com.flw.utils.Utils;
import org.flowable.common.engine.api.FlowableObjectNotFoundException;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskOperationsServiceImpl implements TaskOperationsService {

    @Autowired
    TaskService taskService;

    @Autowired
    Utils utils;

    public List<TaskDetails> getUnAssignedTasks() {
        List<TaskDetails> taskList = new ArrayList();
        try {
            List<Task> tasks = taskService.createTaskQuery().taskUnassigned().list();
            for (Task t : tasks) {
                taskList.add(utils.taskToTaskDetailsMapper(t, taskService.getVariables(t.getId())));
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while retrieving UnAssigned Tasks: ");
            e.printStackTrace();
            throw new FlowableObjectNotFoundException("No Tasks Retrieved");
        }
        return taskList;
    }

    public void completeTask(TaskInfo taskInfo) {
        taskService.complete(taskInfo.getTaskId(), taskInfo.getTaskVariables());
    }

    public void claimTask(String taskId, String userId) {
        taskService.claim(taskId, userId);
    }

    public List<TaskDetails> getTasksByAssignee(String assignee) {
        List<TaskDetails> taskList = new ArrayList();
        try {
            List<Task> tasks = taskService.createTaskQuery().taskAssignee(assignee).list();
            for (Task t : tasks) {
                taskList.add(utils.taskToTaskDetailsMapper(t, taskService.getVariables(t.getId())));
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while retrieving UnAssigned Tasks: ");
            e.printStackTrace();
            throw new FlowableObjectNotFoundException("No Tasks Retrieved");
        }
        return taskList;
    }

    public List<TaskDetails> getTasksByTaskVariable(String varialeName, String variableValue) {
        List<TaskDetails> taskList = new ArrayList();
        try {
            List<Task> tasks = taskService.createTaskQuery().taskVariableValueEquals(varialeName, variableValue).list();
            for (Task t : tasks) {
                taskList.add(utils.taskToTaskDetailsMapper(t, taskService.getVariables(t.getId())));
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while retrieving UnAssigned Tasks: ");
            e.printStackTrace();
            throw new FlowableObjectNotFoundException("No Tasks Retrieved");
        }
        return taskList;
    }

    public List<TaskDetails> getAllAssignedTasks() {
        List<TaskDetails> taskList = new ArrayList();
        try {
            //List<Task> tasks = taskService.createTaskQuery().orderByTaskCreateTime().asc().list();
            List<Task> tasks = taskService.createTaskQuery().taskAssigned().list();
            for (Task t : tasks) {
                taskList.add(utils.taskToTaskDetailsMapper(t, taskService.getVariables(t.getId())));
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while retrieving UnAssigned Tasks: ");
            e.printStackTrace();
            throw new FlowableObjectNotFoundException("No Tasks Retrieved");
        }
        return taskList;
    }
}
