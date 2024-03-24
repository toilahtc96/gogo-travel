package com.travel.gogo.request;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NonNull;

@Data
public class RegisterRequest {
    @NonNull
    private String username;
    @NonNull
    private String password;
    private String name;
    private String fullName;
    private String phone;
    private String email;
}
