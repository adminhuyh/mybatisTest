package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.UserService;



@RestController
public class TerminalController
{
    
    protected static Logger logger = LoggerFactory.getLogger(TerminalController.class);
    
	@Autowired
	private UserService userService;
    
    @RequestMapping("/sss")
    public String sss()
    {
        logger.debug("访问hello");
        return "Hello world!";
    }
    
    @RequestMapping("/testSw")
    public String testSw(){
    	System.out.println("beginxxxxxxxxxxxxxxxxxxxxx");
    	userService.testSw();
    	System.out.println("endxxxxxxxxxxxxxxxxxxxxx");
    	return "success";
    }
    @RequestMapping("/testSaveUser")
    public String testSaveUser(){
    	userService.save();
    	return "success";
    }
    
    
}