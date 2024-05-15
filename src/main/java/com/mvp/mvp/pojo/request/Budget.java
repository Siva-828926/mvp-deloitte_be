package com.mvp.mvp.pojo.request;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Budget {

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

}
