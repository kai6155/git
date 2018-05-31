package com.example.bootTest.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bootTest.mapper.UserMapper;
import com.example.bootTest.model.User;
import com.example.bootTest.service.impl.UserServiceImpl;

import antlr.ByteBuffer;


@Controller
public class indexController {
	
	
	@Resource
	UserServiceImpl userService;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String index() {
		return "hello 80 ***";
	}
	
	

	@RequestMapping("/thymeleaf/hello")
	public String indexForPage(Map<String,Object> map) {
		map.put("msg", "Hello Thymeleaf");
		return "hello";
	}
	
	
	@RequestMapping("/fastJosn")
	@ResponseBody
	public User FastJosn(){
		User u=new User();
		u.setName("hewk");
		u.setPassword("123abc");
		u.setId(111);
		u.setRegtime(new Date());
		
		Map<Object,Object> map=new HashMap<>();
		return u; 
	}
	
	@RequestMapping("/getUser")
	@ResponseBody
	@Cacheable(value="user-key")
	public User getUser() {
	    // User user=userRepository.findByUserName("aa");
		User user =new User();
	    System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");  
	    return user;
	}
	
	@RequestMapping("/uid")
	@ResponseBody
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        User u=userService.getOne(1L);
        return u.getName();
    }
	
	@RequestMapping("send")
	public void SendHttp(HttpServletRequest request,HttpServletResponse response) {
		try {
			URL url = new URL("http://localhost:8080/send2");
			
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(3000);
			
			
			OutputStream outputStream = connection.getOutputStream();
			outputStream.write("value=hewk".getBytes("UTF-8"));
			outputStream.close();
			
			connection.connect();
			
			InputStream in=connection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(in, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer sb = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				sb.append(str);
			}
			
			System.out.println(sb.toString());
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
		}
	}
	
	@RequestMapping("send2")
	public void SendHttp2(HttpServletRequest request,HttpServletResponse response) {
		String s=request.getParameter("value");
		try {
			OutputStream outputStream=response.getOutputStream();
			outputStream.write("hewenkai-return-response".getBytes());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
