package com.example.service;

import com.example.po.User;
import com.example.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TerminalService {
	
    @Autowired
    private UserMapper userMapper;
    
    
    
}
