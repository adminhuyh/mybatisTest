package com.example.service;

import com.example.po.User;
import com.example.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private OrderService orderService;
    
    public User findByName(String name){
        return userMapper.findByName(name);
    }
    
    @Transactional(rollbackFor=Exception.class)
    public void save(){
    	
    	User user = new User();    
		user.setUsername("username");
		user.setPassword("nicai123");
		userMapper.insert(user);
        
    }

	public User queryById(String id) {
		User user = new User();
		user.setId(id);
		return userMapper.selectOne(user);
	}

	public void updateById(String id) {
		User user = userMapper.selectByPrimaryKey(id);
		user.setUsername(UUID.randomUUID().toString());
		userMapper.updateByPrimaryKeySelective(user);
	}
	
	public User getUserById(String id){
		User user= new User();
		user.setId(id);
		User returnUser=userMapper.selectOne(user);
		
		return user;
	}
    @Transactional(rollbackFor=Exception.class)
	public void testSw(){    	
    	System.out.println("userservice beginxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    	User user= new User();
		user.setId("12121");
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		User returnUser=userMapper.selectOne(user);
		System.out.println(returnUser.getUsername());
		System.out.println(returnUser.getPassword());
		System.out.println(returnUser.getId());
		returnUser.setUsername("namenew");
	    userMapper.updateByPrimaryKey(returnUser);
    	System.out.println("userservice beginxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

	}
    
}
