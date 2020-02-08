package com.example.todo.services;

import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task){
        Task createdTask = null;
        Date date= new Date();
        //getTime() returns current time in milliseconds
        long time = date.getTime();
        //Passed the milliseconds to constructor of Timestamp class
        Timestamp completedTime = new Timestamp(time);
        String status = task.getStatus();
        System.out.println(status);
        String completedStatus = "completed";
        if (status.equalsIgnoreCase(completedStatus)){
            task.setStatus(completedStatus);
            task.setCompletedAT(completedTime);
        }
        else{
            task.setStatus(status);
            task.setCompletedAT(null);
        }
        try {
            createdTask = taskRepository.save(task);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        return createdTask;
    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public Task getATask(Long id){
        return taskRepository.findById(id).orElse(null);
    }


    public List<Task> findByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    public void updateTask(Task taskToUpdate, Long id){
        Task oldTask = taskRepository.findById(id).orElse(null);
             taskRepository.save(oldTask);
    }


    public Long deleteTask(Long id){
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return id;
        }
        return null;
    }
}
