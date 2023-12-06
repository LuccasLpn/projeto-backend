package br.com.consumer.consumer.modules.security.controller;

import br.com.consumer.consumer.modules.security.requests.JwtAuthenticationResponse;
import br.com.consumer.consumer.modules.security.requests.SigninRequest;
import br.com.consumer.consumer.modules.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        JwtAuthenticationResponse jwtAuthenticationResponse = authenticationService.signin(request);
        return new ResponseEntity<>(jwtAuthenticationResponse, HttpStatus.OK);
    }
}
