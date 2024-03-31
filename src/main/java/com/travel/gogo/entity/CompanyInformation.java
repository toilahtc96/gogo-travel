package com.travel.gogo.entity;

import com.travel.gogo.constans.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String companyName;

    @Column
    private String companyAddress;

    @Column
    private String companyCityAddress;

    @Column
    private String companyEmail;

    @Column
    private String companyPhone;

    @Column
    private String facebookLink;

    @Column
    private String instagramLink;

    @Column
    private String tikTokLink;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;
}
