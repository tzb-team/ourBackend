package com.example.demo.Entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_patent")
public class Patent implements Serializable {
//    ID（String）name(String),<br>owner(String)<br>walletaddress(String)<br>
//    type(String)<br/>,pool(String),content(String),state(int)//

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 12)
    private String patentID;

    @Column(length = 10)
    private String patentName;

    @ManyToOne(targetEntity = User.class,
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    //     真实姓名，方便管理员核实专利号与持有人是否对应。
    @JoinColumn(referencedColumnName = "realname")
    private String owner;

    @Column(length = 45)
    private String walletAddress;

    @Column(length=3)
    private String type;//      初步分类，后期定具体分类

    @Column(length = 30)
    private String poolID;

    @Column(length = 100)
    private String description;

    @Column
    private Integer patentState;//       逾期？

    @Column
    private boolean isValid;

    @Column
    private int regState;//     注册状态，是否通过等等

    @Column
    private int price;

    @Column
    private int num;//      注册状态,-1表示待审核，0表示审核不通过，1表示审核通过

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRegState(int regState) {
        this.regState = regState;
    }

    public int getRegState() {
        return regState;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setPatentID(String patentID) {
        this.patentID = patentID;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPoolID(String poolID) {
        this.poolID = poolID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPatentState(Integer patentState) {
        this.patentState = patentState;
    }

    public String getPatentID() {
        return patentID;
    }

    public String getPatentName() {
        return patentName;
    }

    public String getOwner() {
        return owner;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public String getType() {
        return type;
    }

    public String getPoolID() {
        return poolID;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPatentState() {
        return patentState;
    }

    public Patent(String patentID, String patentName, String owner, String walletAddress, String type, String poolID, String description, Integer patentState) {
        this.patentID = patentID;
        this.patentName = patentName;
        this.owner = owner;
        this.walletAddress = walletAddress;
        this.type = type;
        this.poolID = poolID;
        this.description = description;
        this.patentState = patentState;
        this.isValid = false;
        this.price = 0;
        this.num = -1;
    }
    public Patent(String patentID, String patentName, String owner){
        this.patentID = patentID;
        this.patentName = patentName;
        this.owner = owner;
    }
    public Patent(){}

}
