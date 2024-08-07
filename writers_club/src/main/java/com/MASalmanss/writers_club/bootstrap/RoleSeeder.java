package com.MASalmanss.writers_club.bootstrap;

import com.MASalmanss.writers_club.entity.Role;
import com.MASalmanss.writers_club.repository.RoleRepository;
import com.MASalmanss.writers_club.utils.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RequiredArgsConstructor
@Component
@Order(1)
public class RoleSeeder implements ApplicationListener<ContextRefreshedEvent> {
    private final RoleRepository roleRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadRoles();
    }

    private void loadRoles(){
        RoleEnum[] roles = {RoleEnum.ADMIN, RoleEnum.USER , RoleEnum.SUPER_ADMIN};

        Map<RoleEnum, String> role_descriptionMap = Map.of(
                RoleEnum.USER , "A User",
                RoleEnum.ADMIN , "A Admin",
                RoleEnum.SUPER_ADMIN , "A Super Admin"
        );
        Arrays.asList(roles).forEach(role -> {
            Optional<Role> roleOptional = roleRepository.findByName(role);
            if(roleOptional.isEmpty()){
                Role newRole = new Role();
                newRole.setName(role);
                newRole.setDescription(role_descriptionMap.get(role));
                roleRepository.save(newRole);
            }
        });

    }
}
