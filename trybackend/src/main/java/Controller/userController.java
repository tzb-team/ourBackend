package Controller;

import Service.userRegService;
import Service.userLogService;
import entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parameter.user.Log;
import reponse.LogRes.LogResponse;

@RestController
@RequestMapping(value = "/user")
public class userController {

    @Autowired
    userRegService regService;

    @Autowired
    userLogService logService;

    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            consumes = {"application/json","application/xml"}
    )
    public void userRegister(@RequestBody user user){
        regService.register(user.getUsername(),user.getPassword(),user.getEmailaddress(),user.getWalletaddress());
    }

    @RequestMapping(value = "/log",
            method = RequestMethod.GET,
            consumes = {"application/json","application/xml"},
            produces = {"application/json", "application/xml"}
    )
    @ResponseBody
    public LogResponse log(@RequestBody Log log){
        return new LogResponse(logService.log(log.getEmail(),log.getPassword()));

    }
}
