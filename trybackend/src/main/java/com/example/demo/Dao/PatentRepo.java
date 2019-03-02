package com.example.demo.Dao;

import com.example.demo.Entity.Patent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatentRepo extends JpaRepository<Patent,String> {

    Patent findByPatentID(String patentID);

    boolean existsByPatentID(String ID);

    List<Patent> findByNum(int num);

    List<Patent> findAll();
}
