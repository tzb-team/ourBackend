package com.example.demo;

import com.example.demo.Param.patentParam.patentReg;
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
public class PatentTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void initPatent1(){
        patentReg patent = new patentReg();
        patent.ID = "11111";
        patent.name = "一种自杀方式";
        patent.owner = "311111111111111111";
        patent.type = "物理电学";
        patent.content = "让你皮";
        FundamentalResponse expected = new FundamentalResponse(true);

        FundamentalResponse response = this.testRestTemplate.postForObject("/patent/patRegister",patent,FundamentalResponse.class);
        assertThat(response).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void initPatent2(){
        patentReg patent = new patentReg();
        patent.ID = "22222";
        patent.name = "一种退学方式";
        patent.owner = "344432199503141732";
        patent.type = "机械工程照明加热武器爆破";
        patent.content = "刺激";

        FundamentalResponse expected = new FundamentalResponse(true);

        FundamentalResponse response = this.testRestTemplate.postForObject("/patent/patRegister",patent,FundamentalResponse.class);
        assertThat(response).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void initPatent3(){
        patentReg patent = new patentReg();
        patent.ID = "33333";
        patent.name = "一种入侵方式";
        patent.owner = "319123199902221222";
        patent.type = "其他";
        patent.content = "不好玩";

        FundamentalResponse expected = new FundamentalResponse(true);

        FundamentalResponse response = this.testRestTemplate.postForObject("/patent/patRegister",patent,FundamentalResponse.class);
        assertThat(response).isEqualToComparingFieldByFieldRecursively(expected);
    }
}
