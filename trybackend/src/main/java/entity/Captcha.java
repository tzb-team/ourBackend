package entity;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "captcha")
public class Captcha {
    @Id
    @Column(name = "email",length = 20)
    private String email;

    @Column(name = "captcha",length = 20)
    private String captcha;

    public String getEmail() {
        return email;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Captcha(){

    }

    public Captcha(String email, String captcha){
        this.email = email;
        this.captcha = captcha;
    }
}
