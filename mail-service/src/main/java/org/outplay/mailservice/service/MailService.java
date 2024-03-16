package org.outplay.mailservice.service;

import lombok.RequiredArgsConstructor;
import org.outplay.mailservice.model.entity.Email;
import org.outplay.mailservice.repository.MailRepository;
import org.springframework.stereotype.Service;

/**
 * @author Gokalp on 16.03.2024
 * @project kafka-sample
 */
@Service
@RequiredArgsConstructor
public class MailService {

    private final MailRepository mailRepository;

    public Email save(Email email) {
        return mailRepository.save(email);
    }


}

