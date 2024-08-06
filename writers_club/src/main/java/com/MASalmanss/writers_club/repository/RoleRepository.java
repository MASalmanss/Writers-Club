package com.MASalmanss.writers_club.repository;

import com.MASalmanss.writers_club.entity.Role;
import com.MASalmanss.writers_club.utils.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RoleEnum name);
}
