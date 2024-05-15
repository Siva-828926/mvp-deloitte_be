package com.mvp.mvp.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class BudgetDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer budgetId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private ProjectDetails projectDetails;
    private String name;
    private String country;
    private String city;
    private String role;
    private String roleType;
    private String roleTier;
    private String startDate;
    private String endDate;
    private String lookupName;
    private String workHoursPerWeek;
    private String hourlyRate;
    private Integer weeklyRate;
    private Integer monthlyRate;
    private Integer yearlyRate;
    private Integer budgetVersion; 
    private Boolean activeBudget;
    // @OneToOne(cascade = CascadeType.ALL)
    // private CostDetails costDetails;
}
