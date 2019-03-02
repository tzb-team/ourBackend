package Service;

import Dao.impl.HibernateDao;
import Dao.service.PatentRepository;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import entity.patent;
import enums.resultMessage.DatabaseRM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderService {

    @Autowired
    PatentRepository repository;


    //      缺少exception，现阶段用boolean判断，过于沙雕
    public boolean register(patent patent){
        if(repository.findByPatent_id(patent.getPatent_id())!=null){       //若存在这个id，说明重复注册，返回false;
            return false;
        }
        repository.insertPatent(patent.getPatent_id(),patent.getPatent_owner(),patent.getPoolid(),patent.isValid(),patent.getValue());
        return true;
    }

    public boolean pendOrder(String patent_id,int value){
        patent p=repository.findByPatent_id(patent_id);
        if(p==null){//        不存在这个专利id
            return false;
        }
        repository.updatePatent(patent_id,p.getPatent_owner(),p.getPoolid(),p.isValid(),value);
        return true;
    }

    public boolean transact(String patent_id,String from, String to){
        patent p=repository.findByPatent_id(patent_id);
        if(p==null){//        不存在这个专利id
            return false;
        }
        repository.updatePatent(patent_id,to,p.getPoolid(),p.isValid(),p.getValue());
        return true;
    }

//    public boolean adduser(String patent_id,String user){
//        HibernateDao<patent> patentDao=new HibernateDao<>(new patent());
//        if(!patentDao.checkKeyExists(patent_id)){
//            return false;
//        }
//        patent patent=patentDao.findByKey(patent_id);
//        if(patent == null){
//            return false;
//        }
//        patent.addPatent_user(user);
//        patentDao.update(patent);
//        DatabaseRM res = patentDao.update(patent);
//        if(res != DatabaseRM.SUCCESS){
//            return false;
//        }
//        return true;
//    }
}
