package com.mvp.mvp.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ProjectDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
    private Integer userId;
    private String projectName;
    private String gvmName;
    private String gvmEmail;

    private Float gvmBudget;
    private String projectStartDate;
    private String projectEndDate;
    
    @OneToMany(mappedBy = "projectDetails" , cascade = CascadeType.ALL)
    private List<BudgetDetails> budgetDetails; 

}
