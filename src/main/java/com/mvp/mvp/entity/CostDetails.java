package com.mvp.mvp.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class CostDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer costDetailsId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BudgetDetails> budgetDetails;
    private Integer totalMonthlyRate;
    private Integer totalYearlyRate;
    private Integer totalGOVOPerMonth;
    private Integer totalGOVOPerYear;
    private Integer finalMontlyRate;
    private Integer finalYearlyRate;
}
