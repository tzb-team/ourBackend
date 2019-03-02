package com.example.demo.Dao;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepo extends JpaRepository<User,String> {

    User findByAccount(String accout);

    User findByEmailAddress(String email);

    List<User> findAll();

    boolean existsByAccount(String account);

    boolean existsByEmailAddress(String emailaddress);
}
