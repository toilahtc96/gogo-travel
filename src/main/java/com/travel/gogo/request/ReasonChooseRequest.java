package com.travel.gogo.request;

import com.travel.gogo.constans.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
public class ReasonChooseRequest {
    private Integer id;
    private String reasonMain;
    private String reasonDescription;
    private String icon;
    @Enumerated(EnumType.STRING)
    private Status status; // Assuming active by default
    private String backgroundImage;
}
