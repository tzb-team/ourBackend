package com.example.demo.Response.userResponse;

public class emailRepeat {
    public boolean isEmailUsed;

    public void setEmailUsed(boolean emailUsed) {
        isEmailUsed = emailUsed;
    }

    public boolean isEmailUsed() {
        return isEmailUsed;
    }

    public emailRepeat(boolean isEmailUsed) {
        this.isEmailUsed = isEmailUsed;
    }
}
