package com.yxw.entity;

import java.io.Serializable;

import javax.jws.HandlerChain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Accessors(chain=true)
@SuppressWarnings("unused")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	private String password;

	public static void main(String[] args) {
		User user = new User();
	}
}
