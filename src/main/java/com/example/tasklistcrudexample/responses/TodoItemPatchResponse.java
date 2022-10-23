package com.example.tasklistcrudexample.responses;

import com.example.tasklistcrudexample.models.TodoItem;

public class TodoItemPatchResponse {
    public String message;
    public TodoItemPatchRequest body;

    public TodoItemPatchResponse(TodoItemPatchRequest todoItem, String message) {
        this.message = message;
        this.body = todoItem;
    }
}
