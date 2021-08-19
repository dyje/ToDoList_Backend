package com.example.todolist.service;

import com.example.todolist.model.Todo;
import com.example.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<Todo> getAllToDos(){
        return toDoRepository.findAll();
     }
    public Todo addNewTodo(Todo todo){
        return toDoRepository.save(todo);
    }

}
