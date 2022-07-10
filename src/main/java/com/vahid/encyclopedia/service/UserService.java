package com.vahid.encyclopedia.service;

import com.vahid.encyclopedia.model.User;
import com.vahid.encyclopedia.repository.UserRepository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    final UserRepository userRepository;
    final MessageDigest md5;

    public UserService(UserRepository userRepository) throws NoSuchAlgorithmException {
        this.userRepository = userRepository;
        this.md5 = MessageDigest.getInstance("MD5");
    }

    public Flux<User> get() {
        return userRepository.findAll();
    }

    public Mono<User> get(String username) {
        return userRepository.findByUsername(username);
    }

    public Mono<User> save(User user) {
        user.setPassword(getHash(user.getPassword()));
        return userRepository.save(user);
    }

    public Mono<Void> delete(String id) {
        return userRepository.deleteById(id);
    }

    private String getHash(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }

}