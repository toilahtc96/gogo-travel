package com.travel.gogo.converted;

import com.travel.gogo.constans.Status;
import com.travel.gogo.entity.Address;
import com.travel.gogo.entity.Users;
import com.travel.gogo.request.AddressRequest;
import com.travel.gogo.request.UserRequest;

import java.sql.Date;
import java.sql.Time;

public class UserConverted {
    public static Users convertUserRequest(UserRequest userRequest) {
        return Users.builder()
                .id(userRequest.getId())
                .name(userRequest.getName())
                .fullName(userRequest.getFullName())
                .email(userRequest.getEmail())
                .phone(userRequest.getPhone())
                .roleId(userRequest.getRoleId())
                .status(Status.ACTIVE)
                .build();
    }
}
