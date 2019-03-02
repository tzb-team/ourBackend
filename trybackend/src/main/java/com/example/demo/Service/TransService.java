package com.example.demo.Service;

import com.example.demo.Dao.OrderRepo;
import com.example.demo.Dao.PatentRepo;
import com.example.demo.Dao.TransRepo;
import com.example.demo.Entity.Patent;
import com.example.demo.Entity.Trans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransService {

    @Autowired
    TransRepo repo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    PatentRepo patentRepo;

    public void transaction(String patentID,String from,String to,int price) {//更改order状态，更改patent所有人，注入一个新的Trans
        int size = repo.findAll().size();
        size++;
        Trans trans = new Trans((long)size,patentID,from,to,price);
        repo.save(trans);

        orderRepo.findByPatentID(patentID).setState(1);

        Patent patent = patentRepo.findByPatentID(patentID);
        patent.setValid(false);
        patent.setPrice(0);
        patent.setOwner(to);
        patentRepo.save(patent);
    }

    public List<Trans> showTrans(){
        return repo.findAll();
    }

    public List<Trans> showSelfTrans(String from){
        return repo.findByOwnerfrom(from);
    }
}
