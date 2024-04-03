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
public class Address {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "address_name")
    private String addressName;
    
    @Column(name = "detail")
    private String detail;
    
    @Column(name = "thumbnail")
    private String thumbnail;
    
    @Column(name = "created_time")
    private LocalDateTime createdTime;
    
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
