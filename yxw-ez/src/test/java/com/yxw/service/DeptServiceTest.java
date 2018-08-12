package com.yxw.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.yxw.entity.Dept;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@SpringBootTest
public class DeptServiceTest {

	@Autowired
	private DeptService deptService;

	@Test
	@Rollback(false)
	public void testInsert() {
		try {
			Dept dept = new Dept();
			dept.setName("人事部");
			deptService.insert(dept);
			System.out.println(dept.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Rollback(false)
	public void testUpdateById() {
		try {
			Dept dept = new Dept();
			dept.setName("行政部");
			deptService.updateById(dept);
			System.out.println(dept.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetById() {
		try {
			Dept user = deptService.getById(1l);
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testList() {
		try {
			List<Dept> userList = deptService.list(null);
			System.out.println(userList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPageList() {
		try {
			PageInfo<Dept> page = deptService.pageList(0, 0, null);
			System.out.println(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
