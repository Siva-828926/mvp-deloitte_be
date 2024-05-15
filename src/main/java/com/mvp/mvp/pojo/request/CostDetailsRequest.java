package com.mvp.mvp.pojo.request;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CostDetailsRequest {
    
    private Integer totalMonthlyAmount;
    private Integer totalYearlyAmount;
    private Integer totalGOVOPerMonth;
    private Integer totalGOVOPerYear;
    private Integer finalMontlyRate;
    private Integer finalYearlyRate;
}
