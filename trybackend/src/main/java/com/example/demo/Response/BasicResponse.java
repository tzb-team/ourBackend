package com.example.demo.Response;

public class BasicResponse {
    private int result = 0;
    private String wrongReason;

    public String getWrongReason() {
        return wrongReason;
    }

    public void setWrongReason(String wrongReason) {
        this.wrongReason = wrongReason;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
