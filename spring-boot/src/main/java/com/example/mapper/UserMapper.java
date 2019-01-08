package com.example.mapper;

import com.example.common.CommonMapper;
import com.example.po.User;

public interface UserMapper extends CommonMapper<User>{
	
    public User findByName(String name);

	//public void save(User user);

	public void updateTwo(User user);
}
