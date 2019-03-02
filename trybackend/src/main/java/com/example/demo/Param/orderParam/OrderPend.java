package com.example.demo.Param.orderParam;

import java.util.Calendar;

public class OrderPend {
    public String patentID;
    public int price;
    public Calendar startTime;
    public Calendar endTime;

    public String getPatentID() {
        return patentID;
    }

    public int getPrice() {
        return price;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }
}
