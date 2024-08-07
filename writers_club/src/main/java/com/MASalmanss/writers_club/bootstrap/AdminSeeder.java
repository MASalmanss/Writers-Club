package com.MASalmanss.writers_club.bootstrap;

import com.MASalmanss.writers_club.entity.Role;
import com.MASalmanss.writers_club.entity.User;
import com.MASalmanss.writers_club.repository.RoleRepository;
import com.MASalmanss.writers_club.repository.UserRepository;
import com.MASalmanss.writers_club.utils.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Order(2)
public class AdminSeeder implements ApplicationListener<ContextRefreshedEvent> {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadAdmin();
    }
    public void loadAdmin(){
        try {

            Optional<User> userOptional = userRepository.findByEmail("admin@admin.com");
            Optional<Role> roleOptional = roleRepository.findByName(RoleEnum.SUPER_ADMIN);
            if (userOptional.isEmpty()) {
                User user = new User();
                        user.setEmail("admin@admin.com");
                        user.setFullName("admin");
                                user.setPassword(passwordEncoder.encode("admin"));
                                user.setRole(roleOptional.get());
                userRepository.save(user);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}