package com.yxw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yxw.entity.User;

@Mapper
public interface UserDao {
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Insert("insert into user(username, password) values(#{username}, #{password})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	//@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", resultType = Long.class, before = false)
	public boolean insert(User user) throws Exception;
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Update("update user set username = #{username},password = #{password} where id = #{id}")
	public boolean updateById(User user) throws Exception;
	
	/**
	 * 根据id获取详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Select("select id,username,password from user where id = #{id}")
	public User getById(Long id) throws Exception;
	
	/**
	 * 查询列表数据
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Select("select id,username,password from user")
	public List<User> list(User user) throws Exception;
	
}
