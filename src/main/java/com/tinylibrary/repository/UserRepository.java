package com.tinylibrary.repository;

import com.tinylibrary.entity.User;
import com.tinylibrary.enums.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByCorreo(String correo);
    boolean existsByRoleUser(RoleUser roleUser);
}
