package com.yxw.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Accessors(chain=true)
@SuppressWarnings("unused")
public class Dept implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long deptId;
	
	@NotEmpty(message="姓名不能为空！")
	private String name;

}
