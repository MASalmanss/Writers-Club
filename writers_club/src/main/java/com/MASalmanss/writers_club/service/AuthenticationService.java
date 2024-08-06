package com.MASalmanss.writers_club.service;

import com.MASalmanss.writers_club.dto.LoginUserDto;
import com.MASalmanss.writers_club.dto.RegisterUserDto;
import com.MASalmanss.writers_club.entity.User;
import com.MASalmanss.writers_club.repository.RoleRepository;
import com.MASalmanss.writers_club.repository.UserRepository;
import com.MASalmanss.writers_club.utils.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final RoleRepository roleRepository;

    public User register(RegisterUserDto registerUserDto){
        User user = User.builder()
                .fullName(registerUserDto.fullName())
                .email(registerUserDto.email())
                .password(passwordEncoder.encode(registerUserDto.password()))
                .role(roleRepository.findByName(RoleEnum.USER).get())
                .build();
      return userRepository.save(user);
    }

    public User login(LoginUserDto loginUserDto){
        Optional<User> user = userRepository.findByEmail(loginUserDto.email());
        if(user.isPresent()){
            if(passwordEncoder.matches(loginUserDto.password(), user.get().getPassword())){
                return user.get();
            }
        }
        else {
            throw new UsernameNotFoundException("User not found");
        }
        throw new BadCredentialsException("Password or email not correct");
    }
}
