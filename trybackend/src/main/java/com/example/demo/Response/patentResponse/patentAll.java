package com.example.demo.Response.patentResponse;

import com.example.demo.Entity.Patent;

public class patentAll {
    public Patent[] patents;


    public patentAll(int size) {
        this.patents = new Patent[size];
    }
}
