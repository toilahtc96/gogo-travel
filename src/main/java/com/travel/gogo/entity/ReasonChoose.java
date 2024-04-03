package com.travel.gogo.entity;

import com.travel.gogo.constans.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReasonChoose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "reason_main", nullable = false)
    private String reasonMain;

    @Column(name = "reason_description", length = Integer.MAX_VALUE)
    private String reasonDescription;

    @Column(name = "icon")
    private String icon;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status; // Assuming active by default

    @Column(name = "background_image")
    private String backgroundImage;

}
