package com.example.tasklistcrudexample.controller;

import com.example.tasklistcrudexample.exception.TodoItemNotFoundException;
import com.example.tasklistcrudexample.models.TodoItem;
import com.example.tasklistcrudexample.responses.TodoItemPatchRequest;
import com.example.tasklistcrudexample.responses.TodoItemPatchResponse;
import com.example.tasklistcrudexample.responses.TodoItemResponse;
import com.example.tasklistcrudexample.service.TaskListBusinessLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TodoItemController {
    private TaskListBusinessLogicService taskListBusinessLogicService;

    @Autowired // Constructor, setter, reflection
    public TodoItemController(TaskListBusinessLogicService taskListBusinessLogicService){
        this.taskListBusinessLogicService = taskListBusinessLogicService;
    }

    // GET tasks
    // GET tasks/{id}
    // POST tasks
    // PUT tasks/{id}
    // PATCH tasks/{id}
    // DELETE tasks/{id}

    @GetMapping()
    public List<TodoItem> getAllTodoItems() {
        return taskListBusinessLogicService.getAllItems();
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoItem> getItemById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(taskListBusinessLogicService.getById(id));
        }
        catch (TodoItemNotFoundException e){
            // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found", e);
            return new ResponseEntity(new TodoItemResponse( null, e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public TodoItem createTodoItem(@RequestBody TodoItem body) {
        return taskListBusinessLogicService.createTodoItem(body);
    }

    @PutMapping("{id}")
    public ResponseEntity<TodoItem> overwriteRecord(@PathVariable Long id, @RequestBody TodoItem body) {
        try {
            return ResponseEntity.ok(taskListBusinessLogicService.replaceTodoItem(id, body));
        }
        catch (TodoItemNotFoundException e){
            return new ResponseEntity(new TodoItemResponse( body, e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<TodoItem> useNonNullFieldsToUpdateRecord(@PathVariable Long id, @RequestBody TodoItemPatchRequest body) {
        try {
            return ResponseEntity.ok(taskListBusinessLogicService.updateTodoItem(id, body));
        }
        catch (TodoItemNotFoundException e){
            return new ResponseEntity(new TodoItemPatchResponse( body, e.getMessage()), HttpStatus.NOT_FOUND);
            // return new ResponseEntity(body, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TodoItemResponse> deleteTheItem(@PathVariable Long id) {
        taskListBusinessLogicService.deleteTodoItem(id);
        return ResponseEntity.ok(new TodoItemResponse(null, "Task " + id + " was deleted."));
    }
}