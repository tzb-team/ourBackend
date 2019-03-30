package com.example.demo;

import com.example.demo.Param.transParam.transaction;
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

public class TransTest {
    @Autowired
    TestRestTemplate testRestTemplate;
    @Test
    public void init1() throws Exception{
        transaction trans=new transaction();
        trans.setPatentID("11111");
        trans.setFrom("311111111111111111");
        trans.setTo("319123199902221222");
        trans.setPrice(32);
        FundamentalResponse expected = new FundamentalResponse(true);

        FundamentalResponse response = this.testRestTemplate.postForObject("/transaction/transaction",trans,FundamentalResponse.class);
        assertThat(response).isEqualToComparingFieldByFieldRecursively(expected);

    }
}
