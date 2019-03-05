package com.example.demo.Dao;

import com.example.demo.Entity.MailCaptcha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaptchaRepo extends JpaRepository<MailCaptcha,Long> {
    MailCaptcha findByEmailAddress(String email);
}
