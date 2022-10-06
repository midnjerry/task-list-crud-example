package com.example.tasklistcrudexample.controller;

import com.example.tasklistcrudexample.models.TodoItem;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TodoItemController {

    @GetMapping("/me")
    public List<TodoItem> getTodoItem() {
        TodoItem todoItem = new TodoItem();
        todoItem.setId(10L);
        todoItem.setTitle("Clean bathroom");
        todoItem.setDescription("Scrub the sink, tub, and toilet");
        todoItem.setCompleted(false);
        return Arrays.asList(todoItem, todoItem, todoItem);
    }

    @GetMapping()
    public List<TodoItem> getAllTodoItems() {
        return Arrays.asList();
    }

    @GetMapping("{id}")
    public TodoItem getItemById(@PathVariable Long id) {
        TodoItem todoItem = new TodoItem();
        todoItem.setId(id);
        todoItem.setTitle("Grabbing a task by id");
        todoItem.setDescription("Make my bed, pick up my clothes");
        todoItem.setCompleted(false);
        return todoItem;
    }

    @PostMapping()
    public TodoItem createTodoItem(@RequestBody TodoItem body) {
        TodoItem todoItem = new TodoItem();
        todoItem.setId(423L);
        todoItem.setCompleted(body.isCompleted());
        todoItem.setTitle(body.getTitle());
        todoItem.setDescription(body.getDescription());
        return todoItem;
    }

    @PutMapping("{id}")
    public TodoItem overwriteRecord(@PathVariable Long id, @RequestBody TodoItem body) {
        return null;
    }

    @PatchMapping("{id}")
    public TodoItem useNonNullFieldsToUpdateRecord(@PathVariable Long id, @RequestBody TodoItem body) {
        return null;
    }

    @DeleteMapping("{id}")
    public TodoItem deleteTheItem(@PathVariable Long id) {
        return null;
    }
}