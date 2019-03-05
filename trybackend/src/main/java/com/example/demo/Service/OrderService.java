package com.example.demo.Service;

import com.example.demo.Dao.OrderRepo;
import com.example.demo.Dao.PatentRepo;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.Patent;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepo repo;
    @Autowired
    PatentRepo patRepo;

    public void createOrder(String patentID, int price, Calendar startTime,Calendar endTime){
        Patent patent = patRepo.findByPatentID(patentID);
        patent.setValid(true);
        patent.setPrice(price);
        patRepo.save(patent);

        Order order = new Order(startTime,endTime,patRepo.findByPatentID(patentID));
        repo.save(order);
    }

    public void cancelOrder(String patentID){
        Patent patent = patRepo.findByPatentID(patentID);
        patent.setValid(false);
        patent.setPrice(0);
        patRepo.save(patent);

        Order order = repo.findByPatentID(patRepo.findByPatentID(patentID));
        order.setState(-1);
        repo.save(order);
    }

    public void priceReset(String patentID,int price){
        Patent patent = patRepo.findByPatentID(patentID);
        patent.setPrice(price);
        patRepo.save(patent);
    }

    public int checkOrderState(String patentID){
        return repo.findByPatentID(patRepo.findByPatentID(patentID)).getState();
    }

    public List<Order> findAllValueableOrder(){
        return repo.findByState(0);
    }
}
