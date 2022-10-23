package com.example.tasklistcrudexample.responses;

import com.example.tasklistcrudexample.models.TodoItem;

public class TodoItemResponse {
    public String message;
    public TodoItem body;

    public TodoItemResponse(TodoItem todoItem, String message) {
        this.message = message;
        this.body = todoItem;
    }
}
