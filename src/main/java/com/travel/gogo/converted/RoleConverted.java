package com.travel.gogo.converted;

import com.travel.gogo.constans.Status;
import com.travel.gogo.entity.Role;
import com.travel.gogo.request.RoleRequest;

public class RoleConverted {
    public static Role convertRoleRequest(RoleRequest roleRequest) {
        return Role.builder()
                .id(roleRequest.getId())
                .roleName(roleRequest.getRoleName())
                .detail(roleRequest.getDetail())
                .status(Status.ACTIVE)
                .build();
    }
}
