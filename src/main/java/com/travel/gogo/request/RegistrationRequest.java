package com.travel.gogo.request;

import com.travel.gogo.constans.Status;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

import java.sql.Date;
import java.sql.Time;

@Getter
public class RegistrationRequest {
    private Integer id;
    private int postId;
    private String name;
    private String phone;
    private Status status;
}
