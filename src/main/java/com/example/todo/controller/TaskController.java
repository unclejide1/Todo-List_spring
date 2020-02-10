package com.example.todo.controller;

import com.example.todo.model.Task;
import com.example.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(path = "/tasks/create", method = RequestMethod.GET)
    public String  createTask(Model model){
        model.addAttribute("task", new Task());
        return "create";
    }

    @RequestMapping(path ="tasks", method = RequestMethod.POST)
    public String saveTask(Task task){
        Task savedTask = taskService.createTask(task);
        return "redirect:/";
    }



    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String viewAllTask(Model model){
        List<Task> allTask = taskService.getAllTask();
        model.addAttribute("tasks", allTask);
        return "tasks";
    }

    @RequestMapping(value = "/tasks/edit/{id}", method = RequestMethod.GET)
    public String editTask(Model model, @PathVariable(value = "id") Long id ){
        Task taskToEdit = taskService.getATask(id);
        model.addAttribute("task", taskToEdit);
        return "edit";
    }

    @RequestMapping(value = "/tasks/view/{id}", method = RequestMethod.GET)
    public String viewTask(Model model, @PathVariable(value = "id") Long id ){
        Task foundTask = taskService.getATask(id);
        model.addAttribute("task", foundTask);
        return "view";
    }


    @RequestMapping(value = "/tasks/{status}", method = RequestMethod.GET)
    public String findByStatus(Model model, @PathVariable String status){
        List<Task> taskFoundByStatus = taskService.findByStatus(status);
        model.addAttribute("tasks", taskFoundByStatus);
        return "viewTaskByStatus";
    }

@RequestMapping(value="/tasks/edit/{id}", method = RequestMethod.PUT)
public String updateTask(@RequestBody Task task, @PathVariable Long id ){
    taskService.updateTask(task, id);
    return "redirect:/tasks";
}

    @RequestMapping(value="/tasks/delete/{id}", method = RequestMethod.GET)
    public String deleteTask(@PathVariable(name = "id") Long id){
         taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
