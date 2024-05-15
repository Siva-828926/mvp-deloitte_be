package com.mvp.mvp.pojo.response;

import java.util.List;

import com.mvp.mvp.entity.Countries;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CountryResponse implements ApiResponse {

    private List<Countries> listOfCountries;

}
