package com.example.demo.Response.orderResponse;

import java.util.Calendar;

public class showOrder {
    String patentID;
    String owner;
    String walletaddress;
    String comment;
    boolean orderState;
    int price;
    Calendar endDate;
    String emailaddress;

    public String getPatentID() {
        return patentID;
    }

    public String getOwner() {
        return owner;
    }

    public String getWalletaddress() {
        return walletaddress;
    }

    public String getComment() {
        return comment;
    }

    public boolean isOrderState() {
        return orderState;
    }

    public int getPrice() {
        return price;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public void setPatentID(String patentID) {
        this.patentID = patentID;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setWalletaddress(String walletaddress) {
        this.walletaddress = walletaddress;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setOrderState(boolean orderState) {
        this.orderState = orderState;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }
}
