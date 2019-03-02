package Service;

import Dao.impl.HibernateDao;
import Dao.service.UserRepository;
import entity.user;
import enums.resultMessage.DatabaseRM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userRegService {

    @Autowired
    UserRepository repository;
    public boolean register(String username,String password,String emailaddress,String walletaddress){
        if(repository.findByEmailaddress(emailaddress)!=null){ //email已注册
            return false;
        }
        repository.insertUser(username,password,emailaddress,walletaddress);
        return true;
    }
}
