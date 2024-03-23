package com.travel.gogo.request;

import com.travel.gogo.constans.Status;
import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;
import java.sql.Time;

@Getter
public class UserRequest {
    private Integer id;
    private String name;
    private int roleId;
    private String fullName;
    private String phone;
    private String email;
    private Status status;
}
