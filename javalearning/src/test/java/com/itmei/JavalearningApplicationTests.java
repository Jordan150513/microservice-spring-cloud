package com.itmei;

import com.sun.jmx.snmp.Timestamp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;
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

	// Date 和 Calendar 之间的转换 并且 实现月日等加减，可以自己实现进位 退位
	@Test
	public void testDateCanlender(){

		long current=System.currentTimeMillis();
		long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();
//		Date startDate = (Date)new Timestamp(zero);

		Date startDate = new Date();
		startDate.setHours(0);
		startDate.setMinutes(0);
		startDate.setSeconds(0);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("00000000000000000   "+dateFormat.format(startDate));

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.MONTH,6);

		Date endDate = calendar.getTime(); // 设置结束时间
		endDate.setHours(23);
		endDate.setMinutes(59);
		endDate.setSeconds(59);
		System.out.println("00000000000000000   "+dateFormat.format(endDate));
	}

	@Test
	public void sortMethod() throws IOException{
		System.out.println("请逐一输入待排序的数：输入结束以end结尾：");
		Scanner sc = new Scanner(System.in);
		String[] stringArr = sc.nextLine().split(",");





		int[] dataArr = {1, 45, 3, 67, 90, 9, 33, 68, 2, 6, 88, 22, 6};

		System.out.println("you input numbers: ");
		for (int i =0;i<dataArr.length ;i++ ) {
			System.out.println(dataArr[i]+" ");
		}


		for (int i = 0; i<dataArr.length;i++ ) {
			for (int j=0; j>dataArr.length-1-i;j++ ) {

				if (dataArr[j]<dataArr[j+1]) {
					int tmp = dataArr[j];
					dataArr[j]=dataArr[j+1];
					dataArr[j+1]=tmp;
				}
			}
		}

		int num = System.in.read();
		System.out.println(num);
	}
}
