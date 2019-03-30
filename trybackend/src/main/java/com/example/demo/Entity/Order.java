package com.example.demo.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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


    @Temporal(TemporalType.DATE)
    private Calendar startDate;

    @Temporal(TemporalType.DATE)
    private Calendar endDate;
    @OneToOne(targetEntity = Patent.class,
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    @JoinColumn(name = "patentid",referencedColumnName = "patentID")
    //后期改成OneTOne和JoinColumn试试
    private Patent patentID;

    @Column
    private int state;//    好像是交易状态？


    public Order( Calendar startDate, Calendar endDate, Patent patentID) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.patentID = patentID;
        state = 0;
    }



    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public void setPatentID(Patent patentID) {
        this.patentID = patentID;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public Patent getPatentID() {
        return patentID;
    }

    public int getState() {
        return state;
    }
    public  Order(){}
}
