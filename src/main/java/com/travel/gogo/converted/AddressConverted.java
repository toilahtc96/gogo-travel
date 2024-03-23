package com.travel.gogo.converted;

import com.travel.gogo.constans.Status;
import com.travel.gogo.entity.Address;
import com.travel.gogo.entity.Role;
import com.travel.gogo.request.AddressRequest;
import com.travel.gogo.request.RoleRequest;

public class AddressConverted {
    public static Address convertAddressRequest(AddressRequest addressRequest) {
        return Address.builder()
                .id(addressRequest.getId())
                .addressName(addressRequest.getAddressName())
                .thumbnail(addressRequest.getThumbnail())
                .detail(addressRequest.getDetail())
                .status(Status.ACTIVE)
                .build();
    }
}
