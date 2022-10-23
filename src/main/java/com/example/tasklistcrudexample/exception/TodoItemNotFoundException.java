package com.example.tasklistcrudexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// @ResponseStatus(code = HttpStatus.NOT_FOUND, reason="video not found")
public class TodoItemNotFoundException extends RuntimeException {
    public TodoItemNotFoundException(String message){
        super(message);
    }
}
