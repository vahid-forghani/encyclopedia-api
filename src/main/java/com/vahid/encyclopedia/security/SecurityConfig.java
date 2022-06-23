package com.vahid.encyclopedia.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final AuthenticationManager authenticationManager;
	private final SecurityContextRepository securityContextRepository;

	@Bean
	SecurityWebFilterChain apiSecurity(ServerHttpSecurity http) {
		http.csrf().disable().cors().disable().formLogin().disable()
		.authenticationManager(authenticationManager)
		.securityContextRepository(securityContextRepository)
		.authorizeExchange(exchanges -> exchanges
				.pathMatchers("/login").permitAll()
				.pathMatchers(HttpMethod.GET, "/articles", "/articles/*").permitAll()
				.anyExchange().authenticated()
		);
		return http.build();
	}

}
