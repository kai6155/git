package com.example.bootTest.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeChatDemo {

	
	@RequestMapping("/prettyWeiXin")
	public void GetWeChatRequest(HttpServletRequest request,HttpServletResponse response){
		
		PrintWriter out;
		if("GET".equals(request.getMethod())){
			System.out.println("GET请求");
			String echostr = request.getParameter("echostr");
			String result = "";
			System.out.println("echostr: " + echostr);
			if (echostr != null && echostr.length() > 1) {
				result = echostr;
				System.out.println("result:" + echostr);
			} 
			try {
				out = response.getWriter();
				out.print(result);
				out.flush();
				out.close();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			
		}
	}
}
