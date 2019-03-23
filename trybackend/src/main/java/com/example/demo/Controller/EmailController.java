package com.example.demo.Controller;

import com.example.demo.Param.emailParam.*;
import com.example.demo.Response.emailResponse.EmailResponse;
import com.example.demo.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@CrossOrigin
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService service;

    @RequestMapping(value = "/VeriSent",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"})
    public EmailResponse sendMail(@RequestBody SendMailParameter param) throws Exception {
        service.insertCode(param.getEmail());
        System.out.println("发送成功");
        EmailResponse response = new EmailResponse();
        response.isRight =true;
        return response;
    }

    @RequestMapping(value = "/emailVerify",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseBody
    public EmailResponse verifyCode(@RequestBody VerifyMailParameter param, HttpServletRequest request) {
        boolean isright = service.checkCode(param.getEmail(),param.getCaptcha());
        EmailResponse response = new EmailResponse();
        response.isRight = isright;
        return response;
    }
}
