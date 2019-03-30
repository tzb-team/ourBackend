package com.example.demo.Entity;

import com.example.demo.Enum.PatentKind;
import org.hibernate.validator.constraints.br.CPF;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_transaction")
public class Trans {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transID;

    @Column(length = 12)
    private String patentID;

    @Column(length = 40)
    private String patentName;

    @Enumerated(EnumType.STRING)
    @Column
    private PatentKind type;

    public String getPatentName() {
        return patentName;
    }

    public PatentKind getType() {
        return type;
    }

    public String getOwnerfrom() {
        return ownerfrom;
    }

    public String getOwnerto() {
        return ownerto;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public void setType(PatentKind type) {
        this.type = type;
    }

    public void setOwnerfrom(String ownerfrom) {
        this.ownerfrom = ownerfrom;
    }

    public void setOwnerto(String ownerto) {
        this.ownerto = ownerto;
    }

    @Column(length = 50)
    private String ownerfrom;

    @Column(length = 50)
    private String ownerto;

    @Column()
    private int price;

    public void setTransID(Long transID) {
        this.transID = transID;
    }

    public void setPatentID(String patentID) {
        this.patentID = patentID;
    }

    public void setFrom(String from) {
        this.ownerfrom = from;
    }

    public void setTo(String to) {
        this.ownerto = to;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getTransID() {
        return transID;
    }

    public String getPatentID() {
        return patentID;
    }

    public String getFrom() {
        return ownerfrom;
    }

    public String getTo() {
        return ownerto;
    }

    public int getPrice() {
        return price;
    }

    public Trans(Long transID, String patentID, String from, String to, int price) {
        this.transID = transID;
        this.patentID = patentID;
        this.ownerfrom = from;
        this.ownerto = to;
        this.price = price;
    }
    public Trans(){}
}
