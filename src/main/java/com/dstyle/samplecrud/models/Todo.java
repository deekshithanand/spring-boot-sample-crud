package com.dstyle.samplecrud.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;    

    private String body;
    
    @Column(name = "done")
    private boolean status;
}
