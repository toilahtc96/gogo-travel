package com.travel.gogo.request;

import com.travel.gogo.constans.Status;
import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

@Getter
public class PostRequest {
    private Integer id;
    private String tourCode;
    private String dayInTour;
    private String tourName;
    private String tourSmallInformation;
    private String priceOncePerson;
    private String benefit;
    private String specialInTour;
    private String mainBackgroundUrl;
    private String contactBackgroundUrl;
    private String informationUrl;
    private Status status;
}
