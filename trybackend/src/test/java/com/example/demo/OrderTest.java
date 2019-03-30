package com.example.demo;

import com.example.demo.Param.orderParam.OrderPend;
import com.example.demo.Response.FundamentalResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderTest {
    @Autowired
    TestRestTemplate testRestTemplate;
    @Test
    public void init1(){
        OrderPend orderPend=new OrderPend();
        orderPend.patentID="11111";
        orderPend.price=23;
        Calendar calendar=Calendar.getInstance();
        Calendar calendar1=Calendar.getInstance();
        calendar.setTime(new Date("1999-11-12"));
        calendar.setTime(new Date("2020-12-30"));
        orderPend.startTime=calendar;

        FundamentalResponse expected = new FundamentalResponse(true);

        FundamentalResponse response = this.testRestTemplate.postForObject("/order/orderPend",orderPend,FundamentalResponse.class);
        assertThat(response).isEqualToComparingFieldByFieldRecursively(expected);

    }
}
