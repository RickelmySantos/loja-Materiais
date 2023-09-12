package com.login.application.controller;

import com.login.application.records.DadosAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/login")
public class AuthController {
    @Autowired
    private AuthenticationManager manager;
    @PostMapping
    public ResponseEntity efetuarLogin(DadosAuthentication dados){
        var token = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        var auth = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }


}
