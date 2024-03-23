package com.travel.gogo.entity;

import com.travel.gogo.constans.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private Integer id;
  @Basic
  @Column(name = "role_name")
  private String roleName;
  @Basic
  @Column(name = "detail")
  private String detail;
  @Basic
  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private Status status;
  @Basic
  @Column(name = "created_time")
  private LocalDateTime createdTime;

}
