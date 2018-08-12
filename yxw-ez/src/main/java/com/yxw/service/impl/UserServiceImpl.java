package com.yxw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxw.dao.UserDao;
import com.yxw.entity.User;
import com.yxw.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public boolean insert(User user) throws Exception {
		return userDao.insert(user);
	}

	@Override
	public boolean updateById(User user) throws Exception {
		return userDao.updateById(user);
	}

	@Override
	public User getById(Long id) throws Exception {
		return userDao.getById(id);
	}

	@Override
	public List<User> list(User user) throws Exception {
		return userDao.list(user);
	}
	
	@Override
	public PageInfo<User> pageList(User user) throws Exception {
		PageHelper.startPage(1, 10);   
        List<User> userList = userDao.list(user);
        PageInfo<User> page = new PageInfo<>(userList);
		return page;
	}
}
