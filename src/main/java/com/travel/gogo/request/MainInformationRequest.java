package com.travel.gogo.request;

import lombok.Data;

@Data
public class MainInformationRequest {
    private Integer id;
    private String title;
    private String subtitle;
    private String smallInformation1;
    private String smallInformation2;
    private String heroImage;
    private boolean status;
}
