package com.example.service;

import com.example.dao.MUserMapper;
import com.example.po.MUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("muserService")
public class MUserServiceImpl implements MUserServiceI {
	@Autowired
	private MUserMapper muserMapper;
		
	@Override
	public List<MUser> getAll() {
		
		return muserMapper.getAll();
	}

	@Override
	public int insert(MUser muser) {
		
		return muserMapper.insert(muser);
	}

	@Override
	public int update(MUser muser) {
		
		return muserMapper.updateByPrimaryKey(muser);
	}

	@Override
	public int delete(String id) {
	
		return muserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public MUser selectByPrimaryKey(String id) {
		
		return muserMapper.selectByPrimaryKey(id);
	}

}
