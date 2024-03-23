package com.travel.gogo.request;

import com.travel.gogo.constans.Status;
import lombok.Getter;

@Getter
public class RoleRequest {
    private Integer id;
    private String roleName;
    private String detail;
    private Status status;
}
