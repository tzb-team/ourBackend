package Controller;

import Service.emailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import parameter.Email.Verification;

//邮箱验证绑定
@RestController
@RequestMapping(value = "/email")
public class emailController  {

    @Autowired
    emailService service;


    @RequestMapping(value = "/sendCaptcha",
            method = RequestMethod.POST,
            consumes = {"application/json","application/xml"} )
    public void sendCaptcha(@RequestBody Verification verify)throws Exception{
        service.send(verify.getEmail());
    }

    @RequestMapping(value = "/verification",
            method = RequestMethod.POST,
            consumes = {"application/json","application/xml"} )
    public void verifyCaptcha(@RequestBody Verification verify)throws Exception{
        service.verify(verify.getEmail(),verify.getCAPTCHA());
    }
}
