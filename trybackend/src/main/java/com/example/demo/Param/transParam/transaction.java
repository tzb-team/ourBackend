package com.example.demo.Param.transParam;

public class transaction {
    //patentID(String),from(String)<br>to(String),price(int),
    private String patentID;
    private String from;
    private String to;
    private int price;

    public String getPatentID() {
        return patentID;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setPatentID(String patentID) {
        this.patentID = patentID;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getPrice() {
        return price;
    }
}
