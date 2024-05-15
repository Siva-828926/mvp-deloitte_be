package com.mvp.mvp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvp.mvp.adapter.ResponeBuilder;
import com.mvp.mvp.constants.MVPConstants;
import com.mvp.mvp.entity.UserDetails;
import com.mvp.mvp.pojo.request.LoginRequest;
import com.mvp.mvp.pojo.response.AuthResponse;
import com.mvp.mvp.pojo.response.MVPResponse;
import com.mvp.mvp.repo.AuthRepo;

@Service
public class LoginService {

    private final AuthRepo authRepo;

    private final ResponeBuilder responeBuilder;

    @Autowired
    private LoginService(ResponeBuilder responeBuilder, AuthRepo authRepo) {
        this.responeBuilder = responeBuilder;
        this.authRepo = authRepo;
    }

    public MVPResponse checkUserCred(LoginRequest loginRequest) {

        Optional<UserDetails> userDetails = authRepo.findByEmailId(loginRequest.getEmailId());
        if (userDetails.isEmpty()) {
            return responeBuilder.buildFailureResponse(MVPConstants.USER_NOT_FOUND);

        } else {
            if (loginRequest.getPassword().equals(userDetails.get().getPassword())) {

                return responeBuilder.buildSuccessRespone(AuthResponse.builder().userId(userDetails.get().getUserId())
                        .userName(userDetails.get().getUserName()).build());
            } else {
                return responeBuilder.buildFailureResponse(MVPConstants.INVALID_CRENDTIALS);
            }
        }

    }

}
