package com.mvp.mvp.pojo.response;

import java.util.List;

import com.mvp.mvp.entity.Cities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CityResponse implements ApiResponse {

    private List<Cities> listOfCities;

}
