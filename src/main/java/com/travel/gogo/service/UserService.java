package com.travel.gogo.service;

import com.travel.gogo.constans.Status;
import com.travel.gogo.converted.UserConverted;
import com.travel.gogo.entity.Users;
import com.travel.gogo.repository.UserRepository;
import com.travel.gogo.request.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void addUser(UserRequest userRequest) {
        Users user = UserConverted.convertUserRequest(userRequest);
        user.setCreatedTime(LocalDateTime.now());
        userRepository.save(user);
    }

    public boolean editUser(UserRequest userRequest) {
        if (userRequest.getId() == null) {
            return false;
        }
        int id = userRequest.getId();
        Users user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return false;
        }
        user.setName(userRequest.getName());
        user.setRoleId(userRequest.getRoleId());
        user.setFullName(userRequest.getFullName());
        user.setPhone(userRequest.getPhone());
        user.setEmail(userRequest.getEmail());
        user.setStatus(userRequest.getStatus());
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Users getById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<Users> getAll() {
        return userRepository.findAll();
    }

    public boolean deleteById(int id) {

        Users user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return false;
        }
        user.setStatus(Status.BLOCK);
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
