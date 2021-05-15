package com.dstyle.samplecrud.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CrudController {
    private static final String APP_UP_STATUS = "App is UP!";

    @GetMapping("/isUp")
    public String isUpStatus() {
        return APP_UP_STATUS;
    }

    @GetMapping("getTodos")
    public void getTodods() {
        // TODO
    }
    
    @PostMapping("/addTodos")
    public void addTodos() {
        // TODO
    }

    @PutMapping("/updateTodos")
    public void updateTodos() {
        // TODO
    }

    @DeleteMapping("/deleteTodos")
    public void deleteTodos() {
        // TODO
    }

}
