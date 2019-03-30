package com.example.demo.Dao;

import com.example.demo.Entity.Order;
import com.example.demo.Entity.Patent;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.tools.JavaCompiler;
import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Long> {

    List<Order> findAll();

    Order findByPatent(Patent patentID);

    Order findById(long id);

    List<Order> findAllByState(int state);
}
