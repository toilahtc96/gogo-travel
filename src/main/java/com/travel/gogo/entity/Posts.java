package com.travel.gogo.entity;

import com.travel.gogo.constans.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Length;

import java.time.LocalDateTime;

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
    
    @Column(name = "tour_code")
    private String tourCode;
    
    @Column(name = "day_in_tour")
    private String dayInTour;
    
    @Column(name = "tour_name")
    private String tourName;
    
    @Column(name = "tour_small_information")
    private String tourSmallInformation;
    
    @Column(name = "price_once_person")
    private String priceOncePerson;

    @Column(name = "benefit", length = Length.LONG)
    private String benefit;

    @Column(name = "special_in_tour", length = Length.LONG)
    private String specialInTour;

    @Column(name = "main_background_url", length = Length.LONG)
    private String mainBackgroundUrl;

    @Column(name = "contact_background_url", length = Length.LONG)
    private String contactBackgroundUrl;

    @Column(name = "information_url", length = Length.LONG)
    private String informationUrl;

    @Column(name = "created_time")
    private LocalDateTime createdTime;
    
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
