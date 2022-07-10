package com.vahid.encyclopedia.controller;

import java.security.Principal;

import com.vahid.encyclopedia.security.AuthRequest;
import com.vahid.encyclopedia.security.AuthResponse;
import com.vahid.encyclopedia.security.JwtUtil;
import com.vahid.encyclopedia.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("login")
    public Mono<ResponseEntity<AuthResponse>> login(@RequestBody AuthRequest authRequest) {
        return userService.get(authRequest.getUsername())
            .filter(userDetails -> getHash(authRequest.getPassword()).equals(userDetails.getPassword()))
            .map(userDetails -> ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(userDetails))))
            .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()));
    }

    @GetMapping("auth")
    public Mono<Principal> getPrincipal(Mono<Principal> principal) {
        return principal;
    }

    private String getHash(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
    
}
