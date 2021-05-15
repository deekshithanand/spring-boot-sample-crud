package com.dstyle.samplecrud.services.serviceimpl;

import java.util.List;

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
        Todo todoDao = new Todo();
        BeanUtils.copyProperties(todo, todoDao);
        log.debug("Saving {} to DB",todoDao);
        Todo savedTodo = todoRepo.save(todoDao);
        BeanUtils.copyProperties(savedTodo, todo);
        return todo;
    }

    @Override
    public TodoDto removeTodo(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TodoDto updateTodo(TodoDto todo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TodoDto> getAllTodos() {
        // TODO Auto-generated method stub
        return null;
    }

}
