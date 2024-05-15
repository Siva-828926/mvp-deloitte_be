package com.mvp.mvp.pojo.response;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoleDetailReponse implements ApiResponse{
    private String lookupName;
    private String roleId;
    private String locationType;
    private Integer billingRatePerHour;
    private Integer monthlyBillingHours;
}
