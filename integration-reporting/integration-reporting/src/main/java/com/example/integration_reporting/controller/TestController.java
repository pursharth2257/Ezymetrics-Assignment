package com.example.integration_reporting.controller;

import com.example.integration_reporting.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final EmailService emailService;

    @Autowired
    public TestController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/send-email")
    public String sendEmail() {
        try {
            emailService.sendAlertEmail(
                    "Test Email Subject",
                    "This is a test email body.",
                    "recipient@example.com" // Change this to your recipient email
            );
            return "Email sent!";
        } catch (Exception e) {
            return "Failed to send email: " + e.getMessage();
        }
    }
}

