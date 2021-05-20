package com.dstyle.samplecrud.services.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import com.dstyle.samplecrud.models.Todo;
import com.dstyle.samplecrud.models.TodoDto;
import com.dstyle.samplecrud.repository.TodoRepo;
import com.dstyle.samplecrud.services.TodoService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepo todoRepo;

    @Override
    public TodoDto addTodo(TodoDto todo) {
        var todoDao = new Todo();
        BeanUtils.copyProperties(todo, todoDao);
        log.debug("Saving {} to DB", todoDao);
        var savedTodo = todoRepo.save(todoDao);
        BeanUtils.copyProperties(savedTodo, todo);
        return todo;
    }

    @Override
    public TodoDto removeTodo(int id) {
        var todoDao = todoRepo.findById(id).orElseThrow();
        todoRepo.deleteById(id);
        log.debug("Element by id : {} deleted successfully", id);
        var todo = new TodoDto();
        BeanUtils.copyProperties(todoDao, todo);
        return todo;
    }

    @Override
    public TodoDto updateTodo(TodoDto todo) {
        var todoDao = todoRepo.findById(todo.getId()).orElseThrow();
        BeanUtils.copyProperties(todo, todoDao);
        log.debug("Going to update Todo : {}", todoDao);
        todoRepo.save(todoDao);
        return todo;
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> allTodos = todoRepo.findAll();
        return allTodos.stream().map(i -> {
            var todoDto = new TodoDto();
            BeanUtils.copyProperties(i, todoDto);
            return todoDto;
        }).collect(Collectors.toList());
    }

}
