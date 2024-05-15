package com.mvp.mvp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvp.mvp.adapter.ResponeBuilder;
import com.mvp.mvp.entity.RoleDetails;
import com.mvp.mvp.pojo.response.CityResponse;
import com.mvp.mvp.pojo.response.CountryResponse;
import com.mvp.mvp.pojo.response.MVPResponse;
import com.mvp.mvp.pojo.response.RoleDetailReponse;
import com.mvp.mvp.pojo.response.RoleResponse;
import com.mvp.mvp.pojo.response.RoleTierResponse;
import com.mvp.mvp.pojo.response.RoleTypeResponse;
import com.mvp.mvp.repo.CityRepo;
import com.mvp.mvp.repo.CountryRepo;
import com.mvp.mvp.repo.RoleDetailRepo;
import com.mvp.mvp.repo.RoleRepo;
import com.mvp.mvp.repo.RoleTierRepo;
import com.mvp.mvp.repo.RoleTypeRepo;

@Service
public class UtilService {

    private final CountryRepo contryRepo;
    private final CityRepo cityRepo;
    private final RoleRepo roleRepo;
    private final RoleTypeRepo roleTypeRepo;
    private final RoleTierRepo roleTierRepo;
    private final ResponeBuilder responeBuilder;
    private final RoleDetailRepo roleDetailRepo;

    @Autowired
    private UtilService(CountryRepo countryRepo, ResponeBuilder responeBuilder, CityRepo cityRepo, RoleRepo roleRepo,
            RoleTypeRepo roleTypeRepo, RoleTierRepo roleTierRepo, RoleDetailRepo roleDetailRepo) {
        this.contryRepo = countryRepo;
        this.responeBuilder = responeBuilder;
        this.cityRepo = cityRepo;
        this.roleRepo = roleRepo;
        this.roleTierRepo = roleTierRepo;
        this.roleTypeRepo = roleTypeRepo;
        this.roleDetailRepo = roleDetailRepo;
    }

    public MVPResponse fetchAllCountries() {
        return responeBuilder
                .buildSuccessRespone(CountryResponse.builder().listOfCountries(contryRepo.findAll()).build());
    }

    public MVPResponse fetchAllCities() {
        return responeBuilder.buildSuccessRespone(CityResponse.builder().listOfCities(cityRepo.findAll()).build());
    }

    public MVPResponse fetchAllRoles() {
        return responeBuilder
                .buildSuccessRespone(RoleResponse.builder().listOfRoles(roleRepo.findAll()).build());
    }

    public MVPResponse fetchAllRoleTypes() {
        return responeBuilder
                .buildSuccessRespone(RoleTypeResponse.builder().listOfRoleTypes(roleTypeRepo.findAll()).build());
    }

    public MVPResponse fetchAllRoleTiers() {
        return responeBuilder
                .buildSuccessRespone(RoleTierResponse.builder().listOfRoleTiers(roleTierRepo.findAll()).build());
    }

    public MVPResponse getBillingHours(String lookupName) {

        System.out.println(" Look up name " + lookupName);
        Optional<RoleDetails> roleDetailReponse = roleDetailRepo.findById(lookupName);
        return responeBuilder
                .buildSuccessRespone(RoleDetailReponse.builder().lookupName(roleDetailReponse.get().getLookupName())
                        .locationType(roleDetailReponse.get().getLocationType())
                        .roleId(roleDetailReponse.get().getRoleId())
                        .billingRatePerHour(roleDetailReponse.get().getBillingRatePerHour())
                        .monthlyBillingHours(roleDetailReponse.get().getMonthlyBillingHours()).build());
    }

}
