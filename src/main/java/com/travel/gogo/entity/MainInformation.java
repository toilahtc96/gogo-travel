package com.travel.gogo.entity;

import com.travel.gogo.constans.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MainInformation{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "subtitle")
    private String subtitle;
    
    @Column(name = "small_information1")
    private String smallInformation1;
    
    @Column(name = "small_information2")
    private String smallInformation2;
    
    @Column(name = "hero_image")
    private String heroImage;
    
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
