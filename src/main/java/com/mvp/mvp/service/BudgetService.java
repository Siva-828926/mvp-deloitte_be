package com.mvp.mvp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvp.mvp.adapter.ResponeBuilder;
import com.mvp.mvp.entity.BudgetDetails;
import com.mvp.mvp.entity.CostDetails;
import com.mvp.mvp.entity.ProjectDetails;
import com.mvp.mvp.pojo.request.Budget;
import com.mvp.mvp.pojo.request.BudgetDetailsRequest;
import com.mvp.mvp.pojo.request.CostDetailsRequest;
import com.mvp.mvp.pojo.response.MVPResponse;
import com.mvp.mvp.repo.BudgetRepo;
import com.mvp.mvp.repo.CostRepo;
import com.mvp.mvp.repo.ProjectRepo;

import jakarta.transaction.Transactional;

@Service
public class BudgetService {

    private final ProjectRepo projectRepo;
    private final BudgetRepo budgetRepo;
    private final ResponeBuilder responeBuilder;
    private final CostRepo costRepo;

    @Autowired
    public BudgetService(ProjectRepo projectRepo, BudgetRepo budgetRepo, ResponeBuilder responeBuilder,
            CostRepo costRepo) {
        this.projectRepo = projectRepo;
        this.budgetRepo = budgetRepo;
        this.responeBuilder = responeBuilder;
        this.costRepo = costRepo;
    }

    @Transactional
    public MVPResponse saveBudgetDetails(BudgetDetailsRequest budgetDetailsRequest) {

        Optional<ProjectDetails> projectDetailsOptional = projectRepo.findById(budgetDetailsRequest.getProjectId());

        try {
            if (projectDetailsOptional.isPresent()) {
                ProjectDetails projectDetails = projectDetailsOptional.get();
                Integer maxBudgetVersion = budgetRepo.findMaxBudgetVersionByProjectId(projectDetails.getProjectId());

                if (maxBudgetVersion == null) {
                    maxBudgetVersion = 1;
                } else {
                    budgetRepo.updateActiveBudgetStatus(projectDetails.getProjectId());
                    maxBudgetVersion++;
                }

                List<BudgetDetails> listOfBudgetDetails = new ArrayList<>();
                for (Budget budget : budgetDetailsRequest.getBudget()) {

                    BudgetDetails budgetDetails = BudgetDetails.builder().projectDetails(projectDetails)
                            .name(budget.getName())
                            .country(budget.getCountry()).city(budget.getCity()).role(budget.getRole())
                            .roleTier(budget.getRoleTier())
                            .roleType(budget.getRoleType()).lookupName(budget.getLookupName())
                            .startDate(budget.getStartDate())
                            .endDate(budget.getEndDate()).workHoursPerWeek(budget.getWorkHoursPerWeek())
                            .hourlyRate(budget.getHourlyRate())
                            .weeklyRate(budget.getWeeklyRate()).monthlyRate(budget.getMonthlyRate())
                            .yearlyRate(budget.getYearlyRate())
                            .budgetVersion(maxBudgetVersion)
                            .activeBudget(true)
                            .build();
                    listOfBudgetDetails.add(budgetDetails);
                }

                CostDetailsRequest costDetailsRequest = budgetDetailsRequest.getCostDetails();

                CostDetails costDetails = CostDetails.builder()
                        .totalMonthlyRate(costDetailsRequest.getTotalMonthlyAmount())
                        .budgetDetails(listOfBudgetDetails)
                        .totalYearlyRate(costDetailsRequest.getTotalYearlyAmount())
                        .totalGOVOPerMonth(costDetailsRequest.getTotalGOVOPerMonth())
                        .totalGOVOPerYear(costDetailsRequest.getTotalGOVOPerYear())
                        .finalMontlyRate(costDetailsRequest.getFinalMontlyRate())
                        .finalYearlyRate(costDetailsRequest.getFinalYearlyRate()).build();

                costRepo.save(costDetails);

            }

            return responeBuilder.buildSuccessRespone(null);
        } catch (Exception e) {
            return responeBuilder.buildFailureResponse("Issue in DB operation! " + e);
        }
    }

}
