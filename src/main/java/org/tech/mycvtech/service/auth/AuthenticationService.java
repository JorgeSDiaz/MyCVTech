package org.tech.mycvtech.service.auth;

import lombok.RequiredArgsConstructor;
import org.tech.mycvtech.config.JwtService;
import org.tech.mycvtech.model.auth.AuthenticationRequest;
import org.tech.mycvtech.model.auth.AuthenticationResponse;
import org.tech.mycvtech.model.auth.RegisterRequest;
import org.tech.mycvtech.model.util.Rol;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.tech.mycvtech.repository.UserMongoRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserMongoRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = org.tech.mycvtech.model.user.User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(Rol.USER)
                .build();

        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = repository.findUserByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
