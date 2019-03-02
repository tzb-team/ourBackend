package com.example.demo.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @Column(length = 20)
    private String account;

    @Column(length = 20)
    private String password;


    @Column(length = 10)
    private String realName;

    @Column(length = 18)
    private String IDcard;

    @Column(length = 50)
    private String walletAddress;

    @Column(length = 30)
    private String emailAddress;
    @OneToMany(targetEntity = Patent.class,
            cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    mappedBy = "owner")
    private List<Patent> patents=new ArrayList<>();


    public void setPatents(List<Patent> patents) {
        this.patents = patents;
    }

    public List<Patent> getPatents() {
        return patents;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    //缺一个持有专利list
    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRealname(String realname) {
        this.realName = realname;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public void setWalletaddress(String walletaddress) {
        this.walletAddress = walletaddress;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getRealname() {
        return realName;
    }

    public String getIDcard() {
        return IDcard;
    }

    public String getWalletaddress() {
        return walletAddress;
    }

    public User(String account, String password, String realName, String IDcard, String walletAddress, String emailAddress) {
        this.account = account;
        this.password = password;
        this.realName = realName;
        this.IDcard = IDcard;
        this.walletAddress = walletAddress;
        this.emailAddress = emailAddress;
    }
    public User(){}
}
