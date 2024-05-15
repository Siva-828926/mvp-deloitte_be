package com.mvp.mvp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mvp.mvp.entity.BudgetDetails;

@Repository
public interface BudgetRepo extends JpaRepository<BudgetDetails, Integer> {

    @Query(value = "SELECT MAX(budget_version) FROM budget_details WHERE project_id = :projectId", nativeQuery = true)
    Integer findMaxBudgetVersionByProjectId(@Param("projectId") Integer projectId);

    @Modifying
    @Query("UPDATE BudgetDetails SET activeBudget = false WHERE projectDetails.projectId = :projectId AND activeBudget = true")
    void updateActiveBudgetStatus(@Param("projectId") Integer projectId);

}
