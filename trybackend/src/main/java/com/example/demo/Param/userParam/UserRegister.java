package com.example.demo.Param.userParam;


public class UserRegister  {
    //account(String),password(String),
    // emailaddress(String),<br>realname(String),
    // <br>IDcard(String)walletaddress(String)<br>

    private String account;

    private String password;

    private String emailaddress;

    private String realname;

    private String idcard;

    private String walletaddress;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setWalletaddress(String walletaddress) {
        this.walletaddress = walletaddress;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public String getRealname() {
        return realname;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getWalletaddress() {
        return walletaddress;
    }
}
