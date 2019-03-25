package com.example.demo.Controller;

import com.example.demo.Param.userParam.*;
import com.example.demo.Response.FundamentalResponse;
import com.example.demo.Response.userResponse.*;
import com.example.demo.Response.userResponse.logRes;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping(value = "/userRegister",
            consumes = {"application/json", "application/xml"})
    public FundamentalResponse register(@RequestBody UserRegister register){
        service.register(register.getAccount(),register.getPassword(),register.getEmailaddress(),register.getRealname(),register.getIdcard(),register.getWalletaddress());
        FundamentalResponse response = new FundamentalResponse();
        response.setSucc(true);
        return response;
    }

    @GetMapping(value = "/userLog",
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public logRes log(@RequestBody UserLog log){
        logRes res = new logRes();
        res.setLogRes(service.log(log.getAcc(),log.getPassword()));
        return res;

    }

    @GetMapping(value = "/checkAcc",
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public accIsRepeat checkAcc(@RequestBody UserAcc acc){
        accIsRepeat res = new accIsRepeat(service.existsByAccount(acc.getAccount()));
        return res;
    }

    @GetMapping(value = "/showUserInfo",
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public showUser showUserInfo(@RequestBody SelectUser user){
        return service.showUserDetail(user.getAccount());

    }

    @GetMapping(value = "/checkEmail",
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public emailRepeat checkEmail(@RequestBody UserEmail email){
        emailRepeat res = new emailRepeat(service.existsByEmail(email.getEmailaddress()));
        return res;
    }
}
