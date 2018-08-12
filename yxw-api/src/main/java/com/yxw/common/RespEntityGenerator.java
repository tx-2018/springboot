package com.yxw.common;

/**
 * 响应结果生成工具
 */
public class RespEntityGenerator {
	private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

	public static RespEntity genSuccessResp() {
		return new RespEntity().setCode(RespCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE);
	}

	public static RespEntity genSuccessResp(Object data) {
		return new RespEntity().setCode(RespCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE).setData(data);
	}

	public static RespEntity genFailResp(String message) {
		return new RespEntity().setCode(RespCode.FAIL).setMessage(message);
	}
}
