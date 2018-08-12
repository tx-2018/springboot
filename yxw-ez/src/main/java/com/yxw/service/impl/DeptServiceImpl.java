package com.yxw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxw.dao.DeptMapper;
import com.yxw.entity.Dept;
import com.yxw.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper deptMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public boolean insert(Dept dept) throws Exception {
		return deptMapper.insert(dept);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public boolean updateById(Dept dept) throws Exception {
		return deptMapper.updateById(dept);
	}

	@Override
	public Dept getById(Long id) throws Exception {
		return deptMapper.getById(id);
	}

	@Override
	public List<Dept> list(Dept dept) throws Exception {
		return deptMapper.list(dept);
	}

	@Override
	public PageInfo<Dept> pageList(int pageNum, int pageSize, Dept dept) throws Exception {
		PageHelper.startPage(1, 10);   
        List<Dept> deptList = deptMapper.pageList(dept);
        PageInfo<Dept> page = new PageInfo<>(deptList);
		return page;
	}
}
