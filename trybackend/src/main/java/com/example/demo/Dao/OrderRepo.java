package com.example.demo.Dao;

import com.example.demo.Entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.tools.JavaCompiler;
import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Long> {

    List<Order> findAll();

    Order findByPatentID(String patentID);

    Order findByOrderID(String orderID);

    List<Order> findByState(int state);
}
