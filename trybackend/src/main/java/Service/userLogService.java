package Service;


import Dao.impl.HibernateDao;
import Dao.service.UserRepository;
import entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userLogService {

    @Autowired
    UserRepository repository;

    public boolean log(String email,String password) {
        if (repository.findByEmailaddress(email)==null) {
            return false;
        }

        user thisuser = repository.findByEmailaddress(email);

        return (thisuser.getPassword().equals(password));
    }
}
