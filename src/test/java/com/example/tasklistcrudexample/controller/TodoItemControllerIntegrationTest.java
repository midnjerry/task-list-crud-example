package com.example.tasklistcrudexample.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.verify;

@SpringBootTest
@AutoConfigureMockMvc
class TodoItemControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TodoItemController mockTodoItemController;

    @Test
    public void getTasks_isWired() throws Exception {
        //when(mockTodoItemController.getAllTodoItems()).thenReturn(Arrays.asList());
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/tasks"))
//                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        verify(mockTodoItemController).getAllTodoItems();
    }

}