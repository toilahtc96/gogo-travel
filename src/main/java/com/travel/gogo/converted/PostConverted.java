package com.travel.gogo.converted;

import com.travel.gogo.constans.Status;
import com.travel.gogo.entity.Address;
import com.travel.gogo.entity.Posts;
import com.travel.gogo.request.AddressRequest;
import com.travel.gogo.request.PostRequest;
import com.travel.gogo.response.PostResponse;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostConverted {
    public static Posts convertPostRequest(PostRequest postRequest) {
        return Posts.builder()
                .id(postRequest.getId())
                .tourCode(postRequest.getTourCode())
                .dayInTour(postRequest.getDayInTour())
                .tourName(postRequest.getTourName())
                .tourSmallInformation(postRequest.getTourSmallInformation())
                .priceOncePerson(postRequest.getPriceOncePerson())
                .benefit(postRequest.getBenefit())
                .specialInTour(postRequest.getSpecialInTour())
                .mainBackgroundUrl(postRequest.getMainBackgroundUrl())
                .contactBackgroundUrl(postRequest.getContactBackgroundUrl())
                .informationUrl(postRequest.getInformationUrl())
                .status(Status.ACTIVE)
                .build();
    }

    public static PostResponse convertToPostResponse(Posts postRequest) {
        return PostResponse.builder()
                .id(postRequest.getId())
                .tourCode(postRequest.getTourCode())
                .dayInTour(postRequest.getDayInTour())
                .tourName(postRequest.getTourName())
                .tourSmallInformation(postRequest.getTourSmallInformation())
                .priceOncePerson(postRequest.getPriceOncePerson())
                .benefits(
                        postRequest.getBenefit() != null ?
                        List.of(postRequest.getBenefit().split(";")) :
                                new ArrayList<>()
                )
                .specialInTours(
                        postRequest.getSpecialInTour() != null ?
                                List.of(postRequest.getSpecialInTour().split(";")) :
                                new ArrayList<>()
                )
                .mainBackgroundUrl(postRequest.getMainBackgroundUrl())
                .contactBackgroundUrl(postRequest.getContactBackgroundUrl())
                .informationUrl(postRequest.getInformationUrl())
                .status(Status.ACTIVE)
                .build();
    }
}
