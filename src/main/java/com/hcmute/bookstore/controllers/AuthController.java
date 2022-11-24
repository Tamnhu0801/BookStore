package com.hcmute.bookstore.controllers;

import com.hcmute.bookstore.dtos.auth.AuthReqDto;
import com.hcmute.bookstore.dtos.auth.AuthResDto;
import com.hcmute.bookstore.entities.ResponseObject;
import com.hcmute.bookstore.security.JwtTokenUtil;
import com.hcmute.bookstore.services.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    JwtTokenUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthReqDto request) {
        try {
            Authentication authentication = authManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

            UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user.getUser());
            AuthResDto response = AuthResDto.builder().email(user.getUsername()).accessToken(accessToken)
                    .build();

            return ResponseEntity.ok().body(
                    ResponseObject.builder().status(HttpStatus.OK).message("Login Successfully")
                            .data(response).build());

        } catch (BadCredentialsException ex) {
            return new ResponseEntity<>(
                    ResponseObject.builder().status(HttpStatus.UNAUTHORIZED).message("Bad login information")
                            .build(), HttpStatus.UNAUTHORIZED);
        }
    }
}
