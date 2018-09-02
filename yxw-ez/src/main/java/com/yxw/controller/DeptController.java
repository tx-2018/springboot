package com.yxw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yxw.common.RespEntity;
import com.yxw.common.RespEntityGenerator;
import com.yxw.entity.Dept;
import com.yxw.service.DeptService;

@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	@RequestMapping(value="/dept/{deptId}", method=RequestMethod.GET)
	public RespEntity getById(@PathVariable Long deptId) throws Exception {
		if (deptId == 1) {
			throw new Exception("异常处理测试");
		}
		Dept dept = deptService.getById(deptId);
		return RespEntityGenerator.genSuccessResp(dept);
	}
	
	@RequestMapping(value = "/dept", method = RequestMethod.POST)
	public RespEntity add(@Valid Dept dept) throws Exception {
		deptService.insert(dept);
		return RespEntityGenerator.genSuccessResp();
	}

	@RequestMapping(value="/dept", method=RequestMethod.GET)
	public RespEntity list(Dept dept) throws Exception {
		//Dept dept = deptService.getById(deptId);
		return RespEntityGenerator.genSuccessResp(dept);
	}
}
