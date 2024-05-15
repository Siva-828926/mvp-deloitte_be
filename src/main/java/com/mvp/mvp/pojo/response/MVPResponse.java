package com.mvp.mvp.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MVPResponse {
    private Boolean serviceStatus;
    private String serviceMessage;
    private ApiResponse data;
}