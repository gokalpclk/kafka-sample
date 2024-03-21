package org.outplay.mailservice.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @author Gokalp on 16.03.2024
 * @project kafka-sample
 */
@Entity
@Table(name = "email")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Email {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "mail")
    private String to;

    @Column(name = "subject")
    private String subject;

    @Column(name = "body")
    private String body;


}
