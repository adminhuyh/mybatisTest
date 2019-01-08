package com.example.service;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.controller.HelloController;
import com.example.mapper.OrderMapper;
import com.example.mapper.UserMapper;
import com.example.po.Order;
import com.example.po.User;

@Service
@Transactional(readOnly = true)
public class OrderService {
	
	protected static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
    @Autowired
    private OrderMapper orderMapper;
    
    @Autowired
    private UserMapper userMapper;
    
    @Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
    public void saveTest(){
        try {
        	User user = new User();
        	user.setId("2");
    		user.setUsername("3");
			userMapper.updateTwo(user);
			
			//int i = 1/0;
			
			Order order = new Order();
			order.setId("1");
			//order.setOrderStatus("1");
			orderMapper.save(order);
		} catch (Exception e) {
			System.out.println("======== adminId ==== 异常了 ==========");
			e.printStackTrace();
		}
    }

    @Transactional(rollbackFor=Exception.class)
    public void saveOrder(){
    	//生成订单号
    	Date date = new Date();
    	String orderNumber = getOrderIdByUUId();
    	logger.info("生成订单 ，订单号为： "+orderNumber);
    	//设置
    	Order order = new Order();
		order.setId(UUID.randomUUID().toString());
		order.setOrderNumber(orderNumber);
		order.setOrderStatus("0");
		order.setCreatTime(date);
		order.setVersion(new Long(0));
		orderMapper.save(order);
		
    }
    
    //生成订单号
    public static String getOrderIdByUUId(){	   
		int machineId = 1;//最大支持1-9个集群机器部署
		String string = UUID.randomUUID().toString();
		int hashCodev = string.hashCode();	   
		System.out.println(string);	   
		if(hashCodev < 0){//有可能是负数
			hashCodev = -hashCodev;	   
		}	   
		//"%015d"的意思：0代表不足位数的补0，这样可以确保相同的位数，15是位数也就是要得到到的字符串长度是15，d代表数字。	   
		return machineId + String.format("%012d", hashCodev);   
	}
    
}
