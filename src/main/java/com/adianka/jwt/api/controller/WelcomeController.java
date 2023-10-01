package com.adianka.jwt.api.controller;

import com.adianka.jwt.api.entity.AuthRequest;
import com.adianka.jwt.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/")
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome(){
        return "Welcome to adianka !!";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
       try {
           authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
           );
       } catch (Exception ex) {
           throw new Exception("Invalid username/password");
       }

       return jwtUtil.generateToken(authRequest.getUserName());
    }
}
