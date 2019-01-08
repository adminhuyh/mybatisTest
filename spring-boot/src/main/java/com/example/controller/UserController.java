package com.example.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.example.po.User;
import com.example.service.UserService;


@Controller
public class UserController {
    
    private Logger logger =Logger.getLogger(UserController.class);
    
    @Autowired
    private UserService userService;
    
    /**
     * @Title:测试通用Mapper 
     * @author: LBQ
     * @date: 2018年12月21日
     */
    @ResponseBody
    @RequestMapping("/testMapper")
    public void testMapper() {
    	
    	User user = userService.queryById("1");
    	
    	userService.updateById("1");
    	
    }
    
    /**
     * @Title: 测试事务
     * @author: LBQ
     * @date: 2018年12月21日  
     * @param name
     */
    @RequestMapping("/test")
    public void updateExample() {
    	
    	userService.save();
    	
    }
    
    @RequestMapping("/getUserInfo/{name}")
    @ResponseBody
    public ModelAndView getUserInfo(@PathVariable String name) {
        User user = userService.findByName(name);
        if(user!=null){
            System.out.println("user.getName():"+user.getUsername());
            logger.info("user.getPwd():"+user.getPassword());
        }
        return new ModelAndView("login");
    }
    
    @RequestMapping("/getUserInfo1")
    @ResponseBody
    public ModelAndView getUserInfo1(@RequestParam(value="name") String name, Model model) {
        User user = userService.findByName(name);
        model.addAttribute("name", user);
        if(user==null){
            return new ModelAndView("error");
        }
        System.out.println("user.getName():"+user.getUsername());
        logger.info("user.getPwd():"+user.getPassword());
        return new ModelAndView("login");
    }
    
}
