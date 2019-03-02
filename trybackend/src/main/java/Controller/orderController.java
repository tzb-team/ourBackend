package Controller;

import entity.patent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import parameter.patent.PendOrder;
import parameter.patent.RegisterPatent;
import Service.orderService;
import parameter.patent.Transaction;
import parameter.patent.UserAddition;

@RestController
@RequestMapping(value = "/order")
public class orderController {

    @Autowired
    orderService service;

    @RequestMapping(value = "/register",
            method= RequestMethod.POST,
            consumes = {"application/json","application/xml"}
    )
    public void registerUser(@RequestBody RegisterPatent patent){
        service.register(new patent(patent.getPatent_id(),patent.getPatent_owner(),patent.getPoolid()));
    }


    @RequestMapping(value = "/pend",
            method = RequestMethod.POST,
            consumes = {"application/json","application/xml"}
            )
    public void pendorder(@RequestBody PendOrder order){
        service.pendOrder(order.getPatent_id(),order.getValue());
    }

    @RequestMapping(value = "/transaction",
            method = RequestMethod.POST,
            consumes = {"application/json","application/xml"}
    )
    public void transaction(@RequestBody Transaction transaction){
        service.transact(transaction.getPatentid(),transaction.getFrom_owner(),transaction.getTo_owener());
    }


//    @RequestMapping(value = "/useraddtion",
//            method = RequestMethod.POST,
//            consumes = {"application/json","application/xml"}
//    )
//    public void adduser(@RequestBody UserAddition userAddition){
//        service.adduser(userAddition.getPatent_id(),userAddition.getUser());
//    }
}
