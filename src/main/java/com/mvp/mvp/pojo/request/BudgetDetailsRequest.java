package com.mvp.mvp.pojo.request;

import java.util.List;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BudgetDetailsRequest {

    private Integer projectId;
    private List<Budget> budget;
    private CostDetailsRequest costDetails;
}
