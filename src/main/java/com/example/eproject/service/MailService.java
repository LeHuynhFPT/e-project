package com.example.eproject.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface MailService {
    String sendMail(MultipartFile[] file, String to, String[] cc, String subject, String body);

    void sendMailUser(String to, String cc, String subject, String body);
}
