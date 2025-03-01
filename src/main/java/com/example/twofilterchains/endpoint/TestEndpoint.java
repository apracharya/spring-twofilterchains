package com.example.twofilterchains.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
public class TestEndpoint {
    @GetMapping("/protected")
    public ResponseEntity<String> protectedEndpoint() {
        return ResponseEntity.ok("You have access to this protected endpoint!");
    }

    @GetMapping("/open")
    public ResponseEntity<String> openEndpoint() {
        return ResponseEntity.ok("You have access to this open endpoint!");
    }

}