package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patent")
public class patent {


    @Id
    @Column(name = "patent_id",length = 20)
    private String patent_id;


    //      专利持有人
    @Column(name="patent_owner",length = 20)
    private  String patent_owmer;


    //      专利使用者集合
////    @Column(name="patent_user")
////    private List<String> patent_user;
//    @ManyToMany
//    @JoinTable(name = "user",joinColumns = {@JoinColumn(referencedColumnName = "walletaddress")})



    //      专利池号
    @Column(name="poolid",length = 20)
    private String poolid;


    //      交易许可
    @Column(name="valid")
    private boolean valid;


    @Column(name ="price",length = 20)
    private  int price;


    public String getPatent_id() {
        return patent_id;
    }

    public String getPatent_owner() {
        return patent_owmer;
    }

//    public List<String> getPatent_user() {
//        return patent_user;
//    }

    public String getPoolid() {
        return poolid;
    }

    public boolean isValid() {
        return valid;
    }

    public int getValue() {
        return price;
    }

    public void setPatent_id(String patent_id) {
        this.patent_id = patent_id;
    }

    public void setPatent_owmer(String patent_owmer) {
        this.patent_owmer = patent_owmer;
    }

//    public void addPatent_user(String user){
//        patent_user.add(user);
//    }
//
//    public boolean removePatent_user(String user){
//        return patent_user.remove(user);
//    }

    public void setPoolid(String poolid) {
        this.poolid = poolid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setValue(int value){
        this.price=value;
    }

    public patent(){

    }
    public patent(String id,String owner,String poolid){
        this.patent_id = id;
        this.patent_owmer = owner;
//        this.patent_user = new ArrayList<>();
//        patent_user.add(owner);
        this.poolid = poolid;
        this.valid = false;
        this.price = 0;
    }
}
