package Dao.service;

import entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<user,String> {

    @Query(value = "select * from users where emailaddress=?1", nativeQuery = true)
    user findByEmailaddress(String address);


    @Transactional
    @Modifying
    @Query(value = "insert into users(username,password,emailaddress,walletaddress)values (?1,?2,?3,?4)",nativeQuery = true)
    void insertUser(String name,String password,String eAddress,String wAddress);

    @Transactional
    @Modifying
    @Query(value = "update users set password=?2,emailaddress=?3,walletaddress=?4 where username=?1;",nativeQuery = true)
    void updateUser(String name,String password,String eAddress,String wAddress);

}
