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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo addNewToDo(@RequestBody Todo todo){
        return toDoService.addNewTodo(todo);
    }

    @DeleteMapping(path = "/{itemId}")
    public Todo removeToDo(@PathVariable Integer itemId){
        return toDoService.removeToDo(itemId);
    }

    @PutMapping(path = "/{itemId}")
    public Todo updateToDo(@PathVariable Integer itemId, @RequestBody  Todo todo){
        return toDoService.updateToDo(itemId, todo);
    }
}
