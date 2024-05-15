package com.mvp.mvp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvp.mvp.adapter.ResponeBuilder;
import com.mvp.mvp.entity.ProjectDetails;
import com.mvp.mvp.pojo.request.ProjectDetailsRequest;
import com.mvp.mvp.pojo.response.MVPResponse;
import com.mvp.mvp.pojo.response.ProjectDetailsResponse;
import com.mvp.mvp.repo.ProjectRepo;

@Service
public class ProjectService {

    private final ProjectRepo projectRepo;
    private final ResponeBuilder responeBuilder;

    @Autowired
    private ProjectService(ProjectRepo projectRepo, ResponeBuilder responeBuilder) {
        this.projectRepo = projectRepo;
        this.responeBuilder = responeBuilder;
    }

    public MVPResponse saveProject(ProjectDetailsRequest projectDetailsRequest) {

        try {
            ProjectDetails projectDetails = ProjectDetails.builder().projectName(projectDetailsRequest.getProjectName())
                    .userId(projectDetailsRequest.getUserId()).gvmName(projectDetailsRequest.getGvmName())
                    .gvmEmail(projectDetailsRequest.getGvmEmail()).gvmBudget(projectDetailsRequest.getGvmBudget())
                    .projectStartDate(projectDetailsRequest.getProjectStartDate())
                    .projectEndDate(projectDetailsRequest.getProjectEndDate()).build();
            projectDetails = projectRepo.save(projectDetails);
            return responeBuilder
                    .buildSuccessRespone(
                            ProjectDetailsResponse.builder().projectId(projectDetails.getProjectId()).build());
        } catch (Exception e) {
            return responeBuilder.buildFailureResponse(e.getMessage());
        }

    }

}
