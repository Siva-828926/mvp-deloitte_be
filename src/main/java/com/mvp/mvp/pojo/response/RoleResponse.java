package com.mvp.mvp.pojo.response;

import java.util.List;
import com.mvp.mvp.entity.Roles;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoleResponse implements ApiResponse {

    private List<Roles> listOfRoles;

}
