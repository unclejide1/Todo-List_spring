//package com.example.todo.integration.Task;
//
//import com.example.todo.controller.HomeController;
//import com.example.todo.controller.TaskController;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//
//public class TaskTest {
//
//    @Autowired
//    private TaskController taskController;
//
//    @Autowired
//    private HomeController homeController;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    @Test
//    void testIndex() throws Exception{
//        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
//    }
//
//    @Test
//    void testViewTaskByStatus() throws Exception{
//        mockMvc.perform(get("/tasks/pending")).andExpect(status().isOk()).andExpect(view().name("viewTaskByStatus"));
//    }
//
//
//}
//
