package com.example.demo.Response.transReponse;

import com.example.demo.Entity.Trans;
import org.hibernate.Transaction;

public class showAll {
    public  Trans[] trans;

    public showAll(int size) {
        this.trans = new Trans[size];
    }
}
