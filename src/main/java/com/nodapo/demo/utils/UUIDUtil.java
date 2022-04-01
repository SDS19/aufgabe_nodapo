package com.nodapo.demo.utils;

import java.util.UUID;

public class UUIDUtil {
	//32-bit Universal Unique Identifier
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-","");
	}
	
}
