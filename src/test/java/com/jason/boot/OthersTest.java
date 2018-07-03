package com.jason.boot;

import org.junit.Test;

import com.jason.boot.utils.StringUtil;

public class OthersTest {
	@Test
	public void test2() {
		for(int i = 0;i<4;i++){
		System.out.println(StringUtil.createUUID());
	}
	}
}
