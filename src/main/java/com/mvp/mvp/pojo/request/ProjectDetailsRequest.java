package com.mvp.mvp.pojo.request;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectDetailsRequest {

    private Integer userId;
    private String projectName;
    private String gvmName;
    private String gvmEmail;
    private Float gvmBudget;
    private String projectStartDate;
    private String projectEndDate;

}
