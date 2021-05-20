package com.dstyle.samplecrud.controllers;

import java.util.List;

import javax.validation.Valid;

import com.dstyle.samplecrud.models.TodoDto;
import com.dstyle.samplecrud.services.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TodoController {
    @Autowired
    TodoService todoService;
    private static final String APP_UP_STATUS = "App is UP!";

    @GetMapping("/isUp")
    public String isUpStatus() {
        return APP_UP_STATUS;
    }

    @GetMapping("getTodos")
    public List<TodoDto> getTodods() {
        return todoService.getAllTodos();
    }

    @PostMapping("/addTodos")
    public TodoDto addTodos(@RequestBody @Valid TodoDto todo) {
        return todoService.addTodo(todo);
    }

    @PutMapping("/updateTodos")
    public TodoDto updateTodos(@RequestBody @Valid TodoDto todo) {
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("/deleteTodos")
    public TodoDto deleteTodos(@RequestParam("id") int id) {
        return todoService.removeTodo(id);
    }

}
