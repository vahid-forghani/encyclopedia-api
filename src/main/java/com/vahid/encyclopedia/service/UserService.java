package com.vahid.encyclopedia.service;

import com.vahid.encyclopedia.model.User;
import com.vahid.encyclopedia.repository.UserRepository;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> get() {
        return userRepository.findAll();
    }

    public Mono<User> get(String username) {
        return userRepository.findByUsername(username);
    }

    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

}