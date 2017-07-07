package com.qiaodan.itmei;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroserviceDiscoveryEurekaServerApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void seperateWithRegu(){

//		'1231231321'.replace(/(\d)(?=(\d{4})+(?!\d))/g, '$1' + ',');
		String string = "123456789";
		String pattern = "/(\\d)(?=(\\d{4})+(?!\\d))/g";
		Pattern p = Pattern.compile(pattern);

		Matcher m = p.matcher(string);
		if (m.find()){
			System.out.println(m);
			System.out.println(m.find());
			System.out.println(m.group());
			System.out.println(m.group(1));
		}
//		return string;
	}
}
