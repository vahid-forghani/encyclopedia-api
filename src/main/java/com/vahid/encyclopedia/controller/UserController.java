package com.vahid.encyclopedia.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vahid.encyclopedia.model.User;
import com.vahid.encyclopedia.service.UserService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    Flux<User> get() {
        return userService.get();
    }

    @GetMapping("{username}")
    Mono<User> get(@PathVariable String username) {
        return userService.get(username);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    Mono<User> save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    Mono<Void> delete(@PathVariable String id) {
        return userService.delete(id);
    }
    
}
