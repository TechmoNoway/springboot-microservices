package com.trikynguci.userservice.repository;

import com.trikynguci.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
