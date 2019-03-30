package com.example.demo.Dao;

import com.example.demo.Entity.Trans;
import com.example.demo.Enum.PatentKind;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransRepo extends JpaRepository<Trans,Long> {

    List<Trans> findAll();

    Trans findByTransID(Long transID);

    Trans findByPatentID(String patentID);
    List<Trans> findBytype(PatentKind kind);
    List<Trans> findByOwnerfrom(String from);
}
