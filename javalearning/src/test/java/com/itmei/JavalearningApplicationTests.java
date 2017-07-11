package com.itmei;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavalearningApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void seperateWithRegu(){

//		'1231231321'.replace(/(\d)(?=(\d{4})+(?!\d))/g, '$1' + ',');
		String string = "123456789";
		// 二狗给的最原始版本的正则表达式 js的语法
//		String pattern = "/(\\d)(?=(\\d{4})+(?!\\d))/g";
		// 正向预查 反向预查
		String pattern = "(\\d)(?=(\\d{3})+(?!\\d))";
		String str1 = "123456789";
		System.out.print(str1.replaceAll(pattern, "$1" + ","));
		System.out.print("\n");

	}

	@Test
	public void testGroup(){
		// 按指定模式在字符串查找
		String line = "This order was placed for QT3000! OK?";
		String pattern = "(\\D*)(\\d+)(.*)";

		// 创建 Pattern 对象
		Pattern r = Pattern.compile(pattern);

		// 现在创建 matcher 对象
		Matcher m = r.matcher(line);
		if (m.find( )) {
			System.out.println("Found value: " + m.group(0) );
			System.out.println("Found value: " + m.group(1) );
			System.out.println("Found value: " + m.group(2) );
			System.out.println("Found value: " + m.group(3) );
		} else {
			System.out.println("NO MATCH");
		}
	}
}
