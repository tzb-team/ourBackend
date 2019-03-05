package com.example.demo.Dao;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserRepo extends JpaRepository<User,Long> {

    User findByAccount(String accout);

    User findByEmailAddress(String email);

    List<User> findAll();

    boolean existsByAccount(String account);

    boolean existsByEmailAddress(String emailaddress);

//    @Transactional
//    @Modifying
//    @Query(value = "update users set password=?2,emailaddress=?3,walletaddress=?4 where username=?1;",nativeQuery = true)
//    void updateUser(String acc,String password,String eAddress,String realname,String idcard,String wAddress);
}
