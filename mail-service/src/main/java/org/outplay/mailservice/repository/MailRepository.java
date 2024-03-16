package org.outplay.mailservice.repository;

import org.outplay.mailservice.model.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Gokalp on 16.03.2024
 * @project kafka-sample
 */
@Repository
public interface MailRepository extends JpaRepository<Email, UUID> {

}