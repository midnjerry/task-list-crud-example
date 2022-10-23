package com.example.tasklistcrudexample.repository;

import com.example.tasklistcrudexample.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

// no bean annotation
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}
