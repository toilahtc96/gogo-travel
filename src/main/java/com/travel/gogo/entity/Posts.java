package com.travel.gogo.entity;

import com.travel.gogo.constans.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Posts {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "address_id")
    private int addressId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "thumbnail")
    private String thumbnail;
    @Basic
    @Column(name = "content_image")
    private String contentImage;
    @Basic
    @Column(name = "created_time")
    private LocalDateTime createdTime;
    @Basic
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
