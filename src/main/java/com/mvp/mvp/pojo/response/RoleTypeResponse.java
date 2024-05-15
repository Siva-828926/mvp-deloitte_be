package com.mvp.mvp.pojo.response;

import java.util.List;
import com.mvp.mvp.entity.RoleTypes;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoleTypeResponse implements ApiResponse {

    private List<RoleTypes> listOfRoleTypes;

}
