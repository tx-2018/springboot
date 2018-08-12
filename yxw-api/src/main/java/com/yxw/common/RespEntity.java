package com.yxw.common;

import com.yxw.entity.Dept;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 统一API响应结果封装
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Accessors(chain=true)
public class RespEntity {
	private int code;
	private String message;
	private Object data;

	public RespEntity setCode(RespCode respCode) {
		this.code = respCode.code;
		return this;
	}


}
