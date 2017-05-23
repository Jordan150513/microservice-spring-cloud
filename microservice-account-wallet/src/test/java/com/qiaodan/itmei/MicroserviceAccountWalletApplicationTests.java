package com.qiaodan.itmei;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroserviceAccountWalletApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public String getmoveInDateStr(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		int date = Integer.parseInt(formatter.format(new Date()));
		Integer beginDate= date-10000;
		Integer endDate = date+10000;
		String moveInDateStr = "["+beginDate.toString()+","+endDate.toString()+"]";
		return moveInDateStr;
	}
}
