package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController
{
    
    protected static Logger logger = LoggerFactory.getLogger(HelloController.class);
    
    @RequestMapping("/s")
    public String helloworld()
    {
        logger.debug("访问hello");
        return "Hello world!";
    }
    
    @RequestMapping("/hello/{name}")
    public String helloName(@PathVariable String name)
    {
        logger.debug("访问helloName,Name={}", name);
        return "Hello " + name;
    }
    @RequestMapping("/testLog")
    public String testLog(){
    	try{
    		logger.debug("xxxxxxxxxxxxxxxxxxxxx");
    		logger.warn("warnxxxxxxxxxxxxxxxxxxxxx");
    		logger.info("infooooooooooooooooooooooo"); 
    		Integer.parseInt("xx");
    	}catch (Exception e) {
			logger.error("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		}finally {
			System.err.println("sssssssssssssssssssss");
		}
    	
    	return "success";    	
    }
    
    
    
}