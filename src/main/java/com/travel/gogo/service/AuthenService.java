package com.travel.gogo.service;

import com.travel.gogo.converted.UserConverted;
import com.travel.gogo.entity.Users;
import com.travel.gogo.repository.UserRepository;
import com.travel.gogo.request.LoginRequest;
import com.travel.gogo.request.RegisterRequest;
import com.travel.gogo.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenService {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    public String getTokenOfUser(LoginRequest request) {
        Optional<Users> users = userRepository.findByUsername(request.getUsername());
        if(!users.isPresent()) {
            return null;
        }
        Users user = users.get();
        if (user.getPassword() != null && user.getPassword().equals(request.getPassword())) {
            return jwtTokenProvider.generateToken(user);
        }
        return null;
    }

    public Users register(RegisterRequest request) {
        return userRepository.save(UserConverted.convertFromRegister(request));
    }

}
