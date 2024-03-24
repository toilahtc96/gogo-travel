package com.travel.gogo.converted;

import com.travel.gogo.constans.Status;
import com.travel.gogo.entity.Address;
import com.travel.gogo.entity.Users;
import com.travel.gogo.request.AddressRequest;
import com.travel.gogo.request.LoginRequest;
import com.travel.gogo.request.RegisterRequest;
import com.travel.gogo.request.UserRequest;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

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

    public static Users convertFromRegister(RegisterRequest registerRequest) {
        return Users.builder()
                .name(registerRequest.getName() == null ? "anonymus" : registerRequest.getName())
                .fullName(registerRequest.getFullName())
                .email(registerRequest.getEmail())
                .phone(registerRequest.getPhone())
                .createdTime(LocalDateTime.now())
                .username(registerRequest.getUsername())
                .password(registerRequest.getPassword())
                .roleId(0)
                .status(Status.ACTIVE)
                .build();
    }
}
