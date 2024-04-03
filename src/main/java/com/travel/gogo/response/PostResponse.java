package com.travel.gogo.response;

import com.travel.gogo.constans.Status;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PostResponse {
    private Integer id;
    private String tourCode;
    private String dayInTour;
    private String tourName;
    private String tourSmallInformation;
    private String priceOncePerson;
    private Status status;
    private String mainBackgroundUrl;
    private String contactBackgroundUrl;
    private String informationUrl;
    private List<String> benefits;
    private List<String> specialInTours;
}
