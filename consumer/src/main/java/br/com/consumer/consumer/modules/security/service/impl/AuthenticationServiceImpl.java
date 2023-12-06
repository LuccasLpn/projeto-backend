package br.com.consumer.consumer.modules.security.service.impl;


import br.com.consumer.consumer.modules.security.requests.JwtAuthenticationResponse;
import br.com.consumer.consumer.modules.security.requests.SigninRequest;
import br.com.consumer.consumer.modules.security.service.AuthenticationService;
import br.com.consumer.consumer.modules.security.service.JwtService;
import br.com.consumer.consumer.modules.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse
                .builder()
                .token("Bearer ".concat(jwt))
                .build();
    }
}