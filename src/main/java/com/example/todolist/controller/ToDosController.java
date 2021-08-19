package com.example.todolist.controller;

import com.example.todolist.model.Todo;
import com.example.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDosController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public List<Todo> getAllToDos(){
        return toDoService.getAllToDos();
    }
}
