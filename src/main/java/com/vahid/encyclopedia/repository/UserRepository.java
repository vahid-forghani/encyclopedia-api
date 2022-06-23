package com.vahid.encyclopedia.repository;

import com.vahid.encyclopedia.model.User;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, String>{
    Mono<User> findByUsername(String username);
}
