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

    public Todo getItemById(Integer itemId){
        return toDoRepository.findById(itemId).orElse(null);
    }

    public Todo removeToDo(Integer itemId){
        Todo itemToBeRemoved = getItemById(itemId);
        if (itemToBeRemoved != null)
            toDoRepository.delete(itemToBeRemoved);
        return itemToBeRemoved;
    }

    public Todo updateToDo(Integer itemId, Todo toDoUpdate){
        Todo itemToBeUpdated = toDoRepository.findById(itemId)
                .map(todo -> new Todo(todo.getId(), todo.getText(), toDoUpdate.isDone()))
                .get();
        return toDoRepository.save(itemToBeUpdated);
    }

    public Todo updateToDoInfo (Todo todo , Todo updatedToDo){
        Todo updatedTodoStatus = new Todo(todo.getId(), todo.getText(), todo.isDone());
        updatedTodoStatus.setDone(updatedToDo.isDone());
        return updatedTodoStatus;
    }

}
