package com.mvp.mvp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mvp.mvp.pojo.request.ProjectDetailsRequest;
import com.mvp.mvp.pojo.response.MVPResponse;
import com.mvp.mvp.service.ProjectService;

@RestController
@RequestMapping("project/")
@CrossOrigin("*")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    private ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("save")
    public ResponseEntity<MVPResponse> projectSaveHandler(@RequestBody ProjectDetailsRequest projectDetailsRequest) {
        return ResponseEntity.ok(projectService.saveProject(projectDetailsRequest));
    }
}
