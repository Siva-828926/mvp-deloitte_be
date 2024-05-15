package com.mvp.mvp.adapter;

import org.springframework.stereotype.Component;

import com.mvp.mvp.pojo.response.ApiResponse;
import com.mvp.mvp.pojo.response.MVPResponse;


@Component
public class ResponeBuilder {

    public MVPResponse buildSuccessRespone(ApiResponse data) {
        return MVPResponse.builder().serviceStatus(true).serviceMessage(null).data(data).build();
    }

    public MVPResponse buildFailureResponse(String failureMsg) {
        return MVPResponse.builder().serviceStatus(false).serviceMessage(failureMsg).build();
    }
}
