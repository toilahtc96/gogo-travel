package com.travel.gogo.service;

import com.travel.gogo.constans.Status;
import com.travel.gogo.converted.AddressConverted;
import com.travel.gogo.converted.RoleConverted;
import com.travel.gogo.entity.Address;
import com.travel.gogo.entity.Role;
import com.travel.gogo.repository.AddressRepository;
import com.travel.gogo.repository.RoleRepository;
import com.travel.gogo.request.AddressRequest;
import com.travel.gogo.request.RoleRequest;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public void addAddress(AddressRequest addressRequest) {
        Address address = AddressConverted.convertAddressRequest(addressRequest);
        addressRepository.save(address);
    }

    public boolean editAddress(AddressRequest addressRequest) {
        if (addressRequest.getId() == null) {
            return false;
        }
        int id = addressRequest.getId();
        Address address = addressRepository.findById(id).orElse(null);
        if (address == null) {
            return false;
        }
        address.setAddressName(addressRequest.getAddressName());
        address.setDetail(addressRequest.getDetail());
        address.setThumbnail(addressRequest.getThumbnail());
        address.setStatus(addressRequest.getStatus());
        try {
            addressRepository.save(address);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Address getById(int id) {
        Address address = addressRepository.findById(id).orElse(null);
        return address;
    }

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public boolean deleteById(int id) {

        Address address = addressRepository.findById(id).orElse(null);
        if (address == null) {
            return false;
        }
        address.setStatus(Status.BLOCK);
        try {
            addressRepository.save(address);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
