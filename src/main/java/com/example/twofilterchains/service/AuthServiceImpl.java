package com.example.twofilterchains.service;

import com.example.twofilterchains.dto.RegisterRequest;
import com.example.twofilterchains.dto.RegisterResponse;
import com.example.twofilterchains.exception.AlreadyExistsException;
import com.example.twofilterchains.persistence.User;
import com.example.twofilterchains.persistence.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {
        if(userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new AlreadyExistsException(request.getUsername() + " is not available");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        return new RegisterResponse(user.getId(), user.getUsername(), "User registered successfully.");
    }

    // TODO: implement this
    //  I am uncertain to use this via service or endpoint
    @Override
    public String logout() {
        return null;
    }
}
