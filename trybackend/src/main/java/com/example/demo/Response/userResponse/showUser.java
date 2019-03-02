package com.example.demo.Response.userResponse;

import com.example.demo.Entity.Patent;

import java.util.List;

public class showUser {

    public String account;

    public String emailaddress;

    public String realname;

    public List<Patent> patents;


    public showUser(String account, String emailaddress, String realname, List<Patent> patents) {
        this.account = account;
        this.emailaddress = emailaddress;
        this.realname = realname;
        this.patents=patents;
    }

    public List<Patent> getPatents() {
        return patents;
    }

    public void setPatents(List<Patent> patents) {
        this.patents = patents;
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

    public String getAccount() {
        return account;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public String getRealname() {
        return realname;
    }
}
