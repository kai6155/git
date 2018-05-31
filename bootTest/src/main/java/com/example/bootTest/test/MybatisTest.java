package com.example.bootTest.test;


import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.example.bootTest.BootTestApplication;
import com.example.bootTest.model.User;
import com.example.bootTest.service.impl.UserServiceImpl;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= BootTestApplication.class)
public class MybatisTest {
    
	@Autowired
    private UserServiceImpl UserServiceImpl;
	

   /* @Test
    public void testSelect() throws Exception {
    	List<User> userList=UserMapper2.getUser();
    	System.out.print("*****");
    	System.out.println(userList.get(0).getId());
    }
    
    

    @Test
    public void testInsert() throws Exception {
    	User u=new User("hewenkai", "123abc", 4, new Date());
    	UserMapper2.insert(u);
    }*/
 
    
    @Test
    public void testInsert2() throws Exception {
    	User u=new User("hewenkai", "123abc", 6, new Date());
    	UserServiceImpl.insert(u);
    }
}
