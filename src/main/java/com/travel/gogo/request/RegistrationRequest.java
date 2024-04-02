package com.travel.gogo.request;

import com.travel.gogo.constans.Status;
import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

@Getter
public class RegistrationRequest {
    private Integer id;
    private int postId;
    private String name;
    private String phone;
    private Status status;
    private String email;
    private String tourName;
    private String information;
}
