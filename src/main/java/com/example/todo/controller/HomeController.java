package com.example.todo.controller;

import com.example.todo.model.Task;
import com.example.todo.model.User;
import com.example.todo.services.TaskService;
import com.example.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {

    private TaskService taskService;



    private UserService userService;

    @Autowired
    public HomeController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        List<Task> allTask = taskService.getAllTask();
        model.addAttribute("tasks", allTask);
        return "index";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUp(Model model){
        model.addAttribute("user", new User());
        return "signUp";
    }

    @RequestMapping(path ="/signup", method = RequestMethod.POST)
    public String saveUser(User user){
        User savedUser = userService.createUser(user);
        return "redirect:/";
    }


}