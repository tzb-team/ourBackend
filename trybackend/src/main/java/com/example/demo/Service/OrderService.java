package com.example.demo.Service;

import com.example.demo.Dao.OrderRepo;
import com.example.demo.Dao.PatentRepo;
import com.example.demo.Dao.UserRepo;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.Patent;
import com.example.demo.Entity.User;
import com.example.demo.Response.orderResponse.showOrder;
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
    @Autowired
    UserRepo userRepo;
    public showOrder showdetails(String patentID){
        Patent patent = patRepo.findByPatentID(patentID);
        Order order = repo.findByPatent(patent);
        User user = patent.getOwner();
        showOrder orderpend = new showOrder();
        orderpend.setPatentID(patentID);
        orderpend.setPrice(patent.getPrice());
        orderpend.setComment(patent.getDescription());
        orderpend.setEndDate(order.getEndDate());
        orderpend.setOwner(user.getRealName());
        orderpend.setEmailaddress(user.getEmailAddress());
        orderpend.setOrderState(patent.isValid());
        return orderpend;
    }
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

        Order order = repo.findByPatent(patRepo.findByPatentID(patentID));
        order.setState(-1);
        repo.save(order);
    }

    public void priceReset(String patentID,int price){
        Patent patent = patRepo.findByPatentID(patentID);
        patent.setPrice(price);
        patRepo.save(patent);
    }

    public int checkOrderState(String patentID){
        return repo.findByPatent(patRepo.findByPatentID(patentID)).getState();
    }

    public List<Order> findAllValueableOrder(){
        List<Order> lists = repo.findAll();
        System.out.println(lists.size());
        return lists;
    }
}
