package com.example.demo.Response;

public class FundamentalResponse {
    boolean isSucc;
    String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setSucc(boolean succ) {
        isSucc = succ;
    }
    public FundamentalResponse(){

    }

    public FundamentalResponse(boolean isSucc) {
        this.isSucc = isSucc;
    }
}
