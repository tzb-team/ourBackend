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
