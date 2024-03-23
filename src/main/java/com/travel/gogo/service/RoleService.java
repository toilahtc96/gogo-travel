package com.travel.gogo.service;

import com.travel.gogo.constans.Status;
import com.travel.gogo.converted.RoleConverted;
import com.travel.gogo.entity.Role;
import com.travel.gogo.repository.RoleRepository;
import com.travel.gogo.request.RoleRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public void addRole(RoleRequest roleRequest) {
        Role role = RoleConverted.convertRoleRequest(roleRequest);
        roleRepository.save(role);
    }

    public boolean editRole(RoleRequest roleRequest) {
        if(roleRequest.getId()==null) {
            return false;
        }
        int id = roleRequest.getId();
        Role role = roleRepository.findById(id).orElse(null);
        if(role == null) {
            return false;
        }
        role.setRoleName(roleRequest.getRoleName());
        role.setDetail(roleRequest.getDetail());
        role.setStatus(roleRequest.getStatus());
        try {
            roleRepository.save(role);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Role getById(int id) {
        Role role = roleRepository.findById(id).orElse(null);
        return role;
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public boolean deleteById(int id) {

        Role role = roleRepository.findById(id).orElse(null);
        if(role == null) {
            return false;
        }
        role.setStatus(Status.BLOCK);
        try {
            roleRepository.save(role);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
