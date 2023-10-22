package com.project.ecommerceproject.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import jakarta.servlet.http.HttpServletRequest;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class AppConfig {

//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.project.ecommerceproject.*")) // Replace with your
//																							// controller package
//				.build();
//	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeHttpRequests(
						Authorize -> Authorize.requestMatchers("/api/**").authenticated().anyRequest().permitAll())
				.addFilterBefore(new JwtValidator(), BasicAuthenticationFilter.class).csrf().disable().cors()
				.configurationSource(new CorsConfigurationSource() {

					@Override
					public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
						// TODO Auto-generated method stub
						CorsConfiguration cfg = new CorsConfiguration();
						cfg.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
						cfg.setAllowedMethods(Collections.singletonList("*"));
						cfg.setAllowCredentials(true);
						cfg.setAllowedHeaders(Collections.singletonList("*"));
						cfg.setExposedHeaders(Arrays.asList("Authorization"));
						cfg.setMaxAge(3600L);

						return cfg;
					}
				}).and().httpBasic().and().formLogin();

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
