package com.example.bootTest.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.bootTest.filter.TimeFilter;
/*
 * @Configuration 注解相当于xml文件中的beans标签
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	
	/**
	 * 整合fastjson
	 * @return
	 */
	/*
	 * @Bean 注解相当于xml文件中的bean标签
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		 FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

	        FastJsonConfig fastJsonConfig = new FastJsonConfig();
	        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
	        
	        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
	        
	        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
	        
	        return new HttpMessageConverters(converter);
	}
	
	/**
	 * 静态资源过滤
	 */
	@Override
	public 	void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}
	
	/**
	 * 过滤器
	 * @return
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean bean=new FilterRegistrationBean();
		
		TimeFilter timeFilter = new TimeFilter();
		bean.setFilter(timeFilter);
	    List<String> urls = new ArrayList<>();
	    urls.add("/hello");
	    bean.setUrlPatterns(urls);
		return bean;
	}
	

}
