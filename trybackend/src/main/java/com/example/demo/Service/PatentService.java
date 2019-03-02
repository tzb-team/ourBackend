package com.example.demo.Service;

import com.example.demo.Dao.PatentRepo;
import com.example.demo.Entity.Patent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatentService {

    @Autowired
    PatentRepo repo;

    public void patentRegister(String ID,String name,String owner,String walletaddress,String type,String pool,String content,int state){
        Patent patent = new Patent(ID,name,owner,walletaddress,type,pool,content,state);
        repo.save(patent);
    }

    public List<Patent> getUncheckList(){
        return repo.findByNum(-1);
    }

    public void changePatentNum(String patentID,int num){
        Patent patent = repo.findByPatentID(patentID);
        patent.setNum(num);
        repo.save(patent);
    }

    public int showNum(String patentID){
        return repo.findByPatentID(patentID).getNum();
    }

    public List<Patent> showAllPatent(){
        return repo.findAll();
    }
}
