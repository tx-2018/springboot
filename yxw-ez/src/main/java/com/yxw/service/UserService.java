package com.yxw.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yxw.entity.User;

public interface UserService {

	/**
	 * 新增用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean insert(User user) throws Exception;
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean updateById(User user) throws Exception;
	
	/**
	 * 根据id获取详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User getById(Long id) throws Exception;
	
	/**
	 * 查询列表数据
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<User> list(User user) throws Exception;
	
	/**
	 * 分页查询
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public PageInfo<User> pageList(User user) throws Exception;
}
