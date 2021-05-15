package com.dstyle.samplecrud.repository;

import com.dstyle.samplecrud.models.Todo;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<Todo, Integer> {

}
