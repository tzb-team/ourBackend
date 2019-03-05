package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_mailcaptcha")
public class MailCaptcha {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String emailAddress;

    @Column(length = 10)
    private String captcha;

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public void setEmailAddress(String emailAddress) {
     this.emailAddress=emailAddress;
    }
    public MailCaptcha(){}
}
