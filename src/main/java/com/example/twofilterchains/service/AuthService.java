package com.example.twofilterchains.service;

import com.example.twofilterchains.dto.RegisterRequest;
import com.example.twofilterchains.dto.RegisterResponse;

public interface AuthService {
    RegisterResponse register(RegisterRequest request);
    String logout();
}
