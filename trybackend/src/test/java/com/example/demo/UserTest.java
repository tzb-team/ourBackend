package com.example.demo;
import com.example.demo.Param.userParam.UserRegister;
import com.example.demo.Response.FundamentalResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void init1(){
        UserRegister register = new UserRegister();
        register.setEmailaddress("123456@qq.com");
        register.setIdcard("319123199902221222");
        register.setAccount("joker");
        register.setRealname("James");
        register.setPassword("123456");

        FundamentalResponse expected = new FundamentalResponse(true);

        FundamentalResponse response = this.testRestTemplate.postForObject("/user/userRegister",register,FundamentalResponse.class);
        assertThat(response).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void init2(){
        UserRegister register = new UserRegister();
        register.setEmailaddress("person@gmail.com");
        register.setIdcard("344432199503141732");
        register.setAccount("murder");
        register.setRealname("Jockey");
        register.setPassword("123456");

        FundamentalResponse expected = new FundamentalResponse(true);

        FundamentalResponse response = this.testRestTemplate.postForObject("/user/userRegister",register,FundamentalResponse.class);
        assertThat(response).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void init3(){
        UserRegister register = new UserRegister();
        register.setEmailaddress("111@qq.com");
        register.setIdcard("311111111111111111");
        register.setAccount("do");
        register.setRealname("man");
        register.setPassword("123456");

        FundamentalResponse expected = new FundamentalResponse(true);

        FundamentalResponse response = this.testRestTemplate.postForObject("/user/userRegister",register,FundamentalResponse.class);
        assertThat(response).isEqualToComparingFieldByFieldRecursively(expected);
    }
}
