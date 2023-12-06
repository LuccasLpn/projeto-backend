package br.com.consumer.consumer.modules.security.service;

import br.com.consumer.consumer.modules.security.requests.JwtAuthenticationResponse;
import br.com.consumer.consumer.modules.security.requests.SigninRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signin(SigninRequest request);
}
