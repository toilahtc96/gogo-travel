package com.travel.gogo.converted;

import com.travel.gogo.constans.Status;
import com.travel.gogo.entity.Address;
import com.travel.gogo.entity.Posts;
import com.travel.gogo.request.AddressRequest;
import com.travel.gogo.request.PostRequest;

import java.sql.Date;
import java.sql.Time;

public class PostConverted {
    public static Posts convertPostRequest(PostRequest postRequest) {
        return Posts.builder()
                .id(postRequest.getId())
                .userId(postRequest.getUserId())
                .addressId(postRequest.getAddressId())
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .thumbnail(postRequest.getThumbnail())
                .contentImage(postRequest.getContentImage())
                .status(Status.ACTIVE)
                .build();
    }
}
