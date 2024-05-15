package com.mvp.mvp.pojo.response;

import java.util.List;
import com.mvp.mvp.entity.RoleTiers;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoleTierResponse implements ApiResponse {

    private List<RoleTiers> listOfRoleTiers;

}
