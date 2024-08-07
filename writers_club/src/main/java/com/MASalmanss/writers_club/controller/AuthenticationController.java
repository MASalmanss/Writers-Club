package com.MASalmanss.writers_club.controller;


import com.MASalmanss.writers_club.dto.authDtos.LoginResponse;
import com.MASalmanss.writers_club.dto.authDtos.LoginUserDto;
import com.MASalmanss.writers_club.dto.authDtos.RegisterUserDto;
import com.MASalmanss.writers_club.entity.User;
import com.MASalmanss.writers_club.service.business.AuthenticationService;
import com.MASalmanss.writers_club.service.business.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.register(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDto loginUserDto){
        User user = authenticationService.login(loginUserDto);
        String token = jwtService.generateToken(user);
        User authenticatedUser = authenticationService.login(loginUserDto);

        LoginResponse loginResponse = LoginResponse
                .builder()
                .token(token)
                .expresedIn(jwtService.getExpiration())
                .build();
        return ResponseEntity.ok(loginResponse);
    }
}
