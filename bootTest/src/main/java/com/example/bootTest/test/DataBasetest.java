package com.example.bootTest.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.bootTest.BootTestApplication;
import com.example.bootTest.dao.UserRepository;
import com.example.bootTest.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= BootTestApplication.class)
public class DataBasetest {
	@Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
        String formattedDate = dateFormat.format(date);
        
        
        
        User user1=new User();       
        user1.setId(0001);
        user1.setName("hewenkai");
        user1.setPassword("123");
        user1.setRegtime(new Date());
        
        userRepository.save(user1);

     /*   Assert.assertEquals(9, userRepository.findAll().size());
        Assert.assertEquals("bb", userRepository.findByNameOrId("bb", "cc@126.com").getName());*/
        //userRepository.delete(userRepository.findByName("wg"));
    }
}
