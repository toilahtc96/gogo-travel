package com.travel.gogo.converted;

import com.travel.gogo.constans.Status;
import com.travel.gogo.entity.Address;
import com.travel.gogo.entity.Registrations;
import com.travel.gogo.request.AddressRequest;
import com.travel.gogo.request.RegistrationRequest;

public class RegistrationConverted {
    public static Registrations convertRegistrationRequest(RegistrationRequest registrationRequest) {
        return Registrations.builder()
                .id(registrationRequest.getId())
                .postId(registrationRequest.getPostId())
                .name(registrationRequest.getName())
                .phone(registrationRequest.getPhone())
                .status(Status.ACTIVE)
                .build();
    }
}
