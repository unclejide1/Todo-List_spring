package com.example.todo.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/edit").setViewName("edit");
        registry.addViewController("/edit").setViewName("edit");
        registry.addViewController("/tasks").setViewName("tasks");
        registry.addViewController("/signup").setViewName("signUp");
        registry.addViewController("/view").setViewName("view");
        registry.addViewController("/viewTaskByStatus").setViewName("viewTaskByStatus");
        registry.addViewController("/create").setViewName("create");
        registry.addViewController("/login").setViewName("login");
    }

}
