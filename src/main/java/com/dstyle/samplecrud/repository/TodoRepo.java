package com.dstyle.samplecrud.repository;

import java.util.List;

import com.dstyle.samplecrud.models.Todo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends CrudRepository<Todo, Integer> {
    @Override
    List<Todo> findAll();
}
