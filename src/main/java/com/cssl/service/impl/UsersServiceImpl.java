package com.cssl.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cssl.dao.UsersDao;
import com.cssl.pojo.Users;
import com.cssl.service.UsersService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 
 * @author
 *
 */
@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	

	@Autowired
	private UsersDao udao;
	
	@Override
	public boolean saveUsers(Users user)  {
		
		System.out.println("UsersServiceImpl saveUsers...");
		if(udao.insertUsers(user)>0) {
			return true;
		}
			
		return false;
	}

	@Override
	public int deleteById(int id) {
		System.out.println("UsersServiceImpl deleteById...");
		return 0;
	}
	
	@Override
	public List<Users> findAll() {
		System.out.println("udao:"+udao);
		return udao.selectAll();
	}

	@Override
	public Page<Users> page(int pageno) {
		Page<Users> page= PageHelper.startPage(pageno, 3);
		udao.selectAll();
		return page;
	}

}
