package com.example.demo.Service;

import com.example.demo.Dao.UserRepo;
import com.example.demo.Entity.User;
import com.example.demo.Response.userResponse.showUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    public void register(String account,String password,String emailaddress,String realname,String IDcard,String walletaddress){
        repo.insertUser(account,password,emailaddress,realname,IDcard,walletaddress);
    }

    public boolean existsByAccount(String account){
        return repo.existsByAccount(account);
    }

    public boolean existsByEmail(String email){
        return repo.existsByEmailAddress(email);
    }

    public boolean log(String acc,String password){
        if(repo.existsByEmailAddress(acc)||repo.existsByAccount(acc)){
            User user = (repo.existsByAccount(acc)?repo.findByAccount(acc):repo.findByEmailAddress(acc));
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public showUser showUserDetail(String account){
        User user = repo.findByAccount(account);
        return new showUser(user.getAccount(),user.getEmailAddress(),user.getRealname(),user.getPatents());
    }
}
