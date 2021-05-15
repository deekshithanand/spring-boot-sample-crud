package com.dstyle.samplecrud.services;

import java.util.List;

import com.dstyle.samplecrud.models.TodoDto;

public interface TodoService {
    public TodoDto addTodo(TodoDto todo);
    public TodoDto removeTodo(int id);
    public TodoDto updateTodo(TodoDto todo);
    public List<TodoDto> getAllTodos();
}
