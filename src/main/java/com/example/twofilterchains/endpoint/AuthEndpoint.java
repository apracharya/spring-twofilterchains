package com.example.twofilterchains.endpoint;

import com.example.twofilterchains.dto.RegisterRequest;
import com.example.twofilterchains.dto.RegisterResponse;
import com.example.twofilterchains.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthEndpoint {
    private final AuthService authService;

    public AuthEndpoint(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
        RegisterResponse registered = authService.register(registerRequest);
        return ResponseEntity.ok(registered);
    }

    @PostMapping("/api/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        Cookie jwtCookie = new Cookie("jwt", "");
        jwtCookie.setHttpOnly(true);
        jwtCookie.setSecure(false); // true in production https
        jwtCookie.setPath("/"); // use same while setting cookie
        jwtCookie.setMaxAge(0); // Expire cookie
        response.addCookie(jwtCookie);

        return ResponseEntity.ok("Logged out successfully!");
    }
}
