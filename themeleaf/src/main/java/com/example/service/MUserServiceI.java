package com.example.service;

import com.example.po.MUser;

import java.util.List;

public interface MUserServiceI {

	List<MUser> getAll();
	
	MUser selectByPrimaryKey(String id);
	
    int insert(MUser muser);
    
    int update(MUser muser);
    
    int delete(String id);
}
