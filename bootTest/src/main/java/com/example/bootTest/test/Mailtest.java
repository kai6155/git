package com.example.bootTest.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.bootTest.BootTestApplication;
import com.example.bootTest.service.EmailService;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= BootTestApplication.class)
public class Mailtest {
	@Autowired
    private EmailService EmailService;

    @Test
    public void test() throws Exception {
    	EmailService.sendSimpleMail("2814421493@qq.com","test simple mail"," hello this is simple mail");
    }
}
