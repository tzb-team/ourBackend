package com.example.demo.Entity;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "tbl_order")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column()
    private Long orderID;

    @Temporal(TemporalType.DATE)
    private Calendar startDate;

    @Temporal(TemporalType.DATE)
    private Calendar endDate;
    @OneToOne(targetEntity = Patent.class)
    //后期改成OneTOne和JoinColumn试试
    private String patentID;

    @Column
    private int state;//    好像是交易状态？


    public Order(Long orderID, Calendar startDate, Calendar endDate, String patentID) {
        this.orderID = orderID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.patentID = patentID;
        state = 0;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public void setPatentID(String patentID) {
        this.patentID = patentID;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Long getOrderID() {
        return orderID;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public String getPatentID() {
        return patentID;
    }

    public int getState() {
        return state;
    }
    public  Order(){}
}
