package parameter.Email;

public class Verification {

    private String email;
    private String CAPTCHA;

    public String getEmail() {
        return email;
    }

    public String getCAPTCHA() {
        return CAPTCHA;
    }

    public Verification(String email,String CAPTCHA){
        this.email = email;
        this.CAPTCHA = CAPTCHA;
    }

    public Verification(String email){
        this.email = email;
        this.CAPTCHA = "";
    }
}
