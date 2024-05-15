package com.mvp.mvp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Countries {

    @Id
    private Integer id;
    private String name;
    private Integer workHoursPerWeek;
    private Integer workHoursPerMonth;
}
