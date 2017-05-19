package com.qiaodan.itmei;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroserviceConsumerFeignApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testStr(){
		String  str = formatterTotal("1234567888999999");
		System.out.println(str);
	}

	// 当年如此简单的东西 都没有写好
	public String formatterTotal(String str){

		if (str.length()<4) return str;
		for (int i =str.length()-3;i>0;i=i-3){
			str = str.substring(0,i)+","+str.substring(i);
		}
		return str;
	}
}
