package com.travel.gogo.request;

import com.travel.gogo.constans.Status;
import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;
import java.sql.Time;

@Getter
public class PostRequest {
    private Integer id;
    private int userId;
    private int addressId;
    private String title;
    private String content;
    private String thumbnail;
    private String contentImage;
    private Status status;
}
