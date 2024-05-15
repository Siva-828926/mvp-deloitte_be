package com.mvp.mvp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cities {
    
    @Id
    private int id;
    private String name;
}
