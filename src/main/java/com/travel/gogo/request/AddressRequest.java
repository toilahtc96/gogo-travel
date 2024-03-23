package com.travel.gogo.request;

import com.travel.gogo.constans.Status;
import lombok.Getter;

@Getter
public class AddressRequest {
    private Integer id;
    private String addressName;
    private String detail;
    private String thumbnail;
    private Status status;
}
