package com.example.demo.Param.patentParam;

public class patentReg {
    //ID（String）name(String),<br>owner(String)
    // <br>walletaddress(String)<br>,type(String)
    // <br/>,pool(String),content(String),state(int)//逾期?

    private String ID;
    private String name;
    private String owner;
    private String walletaddress;
    private String type;
    private String pool;
    private String content;
    private int state;

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getWalletaddress() {
        return walletaddress;
    }

    public String getType() {
        return type;
    }

    public String getPool() {
        return pool;
    }

    public String getContent() {
        return content;
    }

    public int getState() {
        return state;
    }
}
