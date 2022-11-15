package com.example.tasklistcrudexample.controller;

import com.example.tasklistcrudexample.service.TaskListBusinessLogicService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TodoItemControllerTest {

    TaskListBusinessLogicService mockTaskListBusinessLogicService;

    @BeforeEach
    public void setup(){
        mockTaskListBusinessLogicService = mock(TaskListBusinessLogicService.class);

    }

    @Test
    public void getAll_CallsService(){
        TodoItemController todoItemController = new TodoItemController(mockTaskListBusinessLogicService);
        todoItemController.getAllTodoItems();
        verify(mockTaskListBusinessLogicService).getAllItems();
    }

    @Test
    public void getAll_returnsValueFromService(){
        when(mockTaskListBusinessLogicService.getAllItems()).thenReturn(null);
        TodoItemController todoItemController = new TodoItemController(mockTaskListBusinessLogicService);
        assertEquals(null, todoItemController.getAllTodoItems());

    }
}