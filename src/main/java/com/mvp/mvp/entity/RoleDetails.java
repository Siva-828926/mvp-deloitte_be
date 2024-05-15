package com.mvp.mvp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RoleDetails {

    @Id
    private String lookupName;
    private String roleId;
    private String locationType;
    private Integer billingRatePerHour;
    private Integer monthlyBillingHours;


}
