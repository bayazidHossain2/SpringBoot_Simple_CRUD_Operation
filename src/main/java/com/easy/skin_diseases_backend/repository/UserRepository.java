package com.easy.skin_diseases_backend.repository;

import com.easy.skin_diseases_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
