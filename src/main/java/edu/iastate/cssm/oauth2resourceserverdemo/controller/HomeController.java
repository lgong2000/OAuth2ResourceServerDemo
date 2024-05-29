package edu.iastate.cssm.oauth2resourceserverdemo.controller;

import edu.iastate.cssm.oauth2resourceserverdemo.model.LoginRequest;
import edu.iastate.cssm.oauth2resourceserverdemo.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public HomeController(TokenService tokenService, AuthenticationManager authenticationManager, PasswordEncoder encoder) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @PostMapping("/token")
    public String token(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
        return tokenService.createToken(authentication);
    }
}
