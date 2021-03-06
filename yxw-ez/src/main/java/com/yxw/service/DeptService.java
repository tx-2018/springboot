package com.yxw.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yxw.entity.Dept;
import com.yxw.entity.User;

public interface DeptService {

	/**
	 * 新增部门
	 * @param dept
	 * @return
	 * @throws Exception
	 */
	public boolean insert(Dept dept) throws Exception;
	
	/**
	 * 修改部门
	 * @param dept
	 * @return
	 * @throws Exception
	 */
	public boolean updateById(Dept dept) throws Exception;
	
	/**
	 * 根据id获取详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Dept getById(Long id) throws Exception;
	
	/**
	 * 查询列表
	 * @param dept
	 * @return
	 * @throws Exception
	 */
	public List<Dept> list(Dept dept) throws Exception;
	
	/**
	 * 分页查询
	 * @param dept
	 * @return
	 * @throws Exception
	 */
	public PageInfo<Dept> pageList(int pageNum, int pageSize, Dept dept) throws Exception;
}
