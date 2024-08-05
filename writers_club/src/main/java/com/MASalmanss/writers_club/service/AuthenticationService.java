package com.MASalmanss.writers_club.service;

import com.MASalmanss.writers_club.dto.LoginUserDto;
import com.MASalmanss.writers_club.dto.RegisterUserDto;
import com.MASalmanss.writers_club.entity.User;
import com.MASalmanss.writers_club.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(RegisterUserDto registerUserDto){
        User user = User.builder()
                .fullName(registerUserDto.fullName())
                .email(registerUserDto.email())
                .password(passwordEncoder.encode(registerUserDto.password()))
                .build();
      return userRepository.save(user);
    }

    public User login(LoginUserDto registerUserDto){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(registerUserDto.email() , registerUserDto.password()));
        return userRepository.findByEmail(registerUserDto.email()).orElseThrow();
    }
}
