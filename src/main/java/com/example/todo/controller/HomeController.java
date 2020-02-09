package com.example.todo.controller;

import com.example.todo.model.Task;
import com.example.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private TaskService taskService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        List<Task> allTask = taskService.getAllTask();
        model.addAttribute("tasks", allTask);
        return "index";
    }
}