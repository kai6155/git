package com.example.bootTest.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TimeFilter implements Filter {

	@Override
	public void destroy() {
		 System.out.println("=======销毁过滤器=========");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		long start = System.currentTimeMillis();

		arg2.doFilter(arg0, arg1);

        System.out.println("filter 耗时：" + (System.currentTimeMillis() - start));
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("=======初始化过滤器=========");
	}

}
