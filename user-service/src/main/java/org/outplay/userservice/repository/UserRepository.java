package org.outplay.userservice.repository;

import org.outplay.userservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Gokalp on 13.03.2024
 * @project user-service
 */
public interface UserRepository extends JpaRepository<User, UUID> {
}
