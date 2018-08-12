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
import com.yxw.entity.User;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	@Rollback(false)
	public void testInsert() {
		try {
			User user = new User();
			user.setUsername("kobe");
			user.setPassword("123456");
			userService.insert(user);
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Rollback(false)
	public void testUpdateById() {
		try {
			User user = new User();
			user.setId(5l);
			user.setUsername("nash");
			user.setPassword("123456");
			userService.updateById(user);
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetById() {
		try {
			User user = userService.getById(5l);
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testList() {
		try {
			List<User> userList = userService.list(null);
			System.out.println(userList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPageList() {
		try {
			PageInfo<User> page = userService.pageList(null);
			System.out.println(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
