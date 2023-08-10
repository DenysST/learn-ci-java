package com.ds.forlearnci.repositories;

import com.ds.forlearnci.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
