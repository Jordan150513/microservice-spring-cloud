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

import static org.apache.coyote.http11.Constants.a;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavalearningApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void numbers() {
        // 记得看过一个文章 100 之内的 做了缓存 所以两个变量是一样的，但是100 之外的 是没有做缓存，两个变量是不相等的。。。但是为啥 不是呢？

//        int a = 100;
//        int b = 100;
//        int c = 10000;
//        int d = 10000;

        // 上下两种情况是不一样的

        Integer a = 100;
        Integer b = 100;
        Integer c = 10000;
        Integer d = 10000;

        // 这里是两个对象的指针进行判断的 判断的是对象的指针
        System.out.println(a == b);
        System.out.println(c == d);

        // equals 判断的是对象的值 类型和value
        System.out.println(a.equals(b));
        System.out.println(c.equals(d));
    }

    @Test
    public void seperateWithRegu() {

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
    public void testGroup() {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }
    }

    // Date 和 Calendar 之间的转换 并且 实现月日等加减，可以自己实现进位 退位
    @Test
    public void testDateCanlender() {

        long current = System.currentTimeMillis();
        long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();
//		Date startDate = (Date)new Timestamp(zero);

        Date startDate = new Date();
        startDate.setHours(0);
        startDate.setMinutes(0);
        startDate.setSeconds(0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("00000000000000000   " + dateFormat.format(startDate));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.MONTH, 6);

        Date endDate = calendar.getTime(); // 设置结束时间
        endDate.setHours(23);
        endDate.setMinutes(59);
        endDate.setSeconds(59);
        System.out.println("00000000000000000   " + dateFormat.format(endDate));
    }

    @Test
    public void sortMethod() throws IOException {
        // quick sort
        // 需要考虑周全的两点：
        // 1、临近的元素交换之后，游标不会有相等相遇的情况出现就越过彼此了会出现左边游标大于了右边的游标
        // 2、交换之后 两端向各自方向更新游标
        int[] dataArr = {1, 45, 3, 67, 90, 9, 33, 68, 2, 6, 88, 22, 6};

        System.out.println("you input numbers: ");
        this.printNumbers(dataArr);
        // 开始位置和结束位置
        int start = 0;
        int end = dataArr.length - 1;
        quickSort(start, end, dataArr);

    }

    public void quickSort(int start, int end, int[] dataArr) {
        // 基准
        int p = start;
        // 游标变量
        int i = start;
        int j = end;

        while (i < j) {
            while (dataArr[j] >= dataArr[p] && i < j) {
                j--;
            }
            while (dataArr[i] <= dataArr[p] && i < j) {
                i++;
            }
            if (i < j) {
                int tmp = dataArr[i];
                dataArr[i] = dataArr[j];
                dataArr[j] = tmp;
                i++;// 这里经常忘记操作
                j--;
            }
        }
        if (i >= j) {// 这里需要考虑周全，有可能两个临近的元素交换了之后，两个越过彼此
            // 一次排序结束了
            int tmp = dataArr[p];
            dataArr[p] = dataArr[j];
            dataArr[j] = tmp;
            printNumbers(dataArr);
            p = j;
        }
        // 进行分两边递归的快排
        if (start < p - 1) {
            quickSort(start, p - 1, dataArr);
        }
        if (p + 1 < end) {
            quickSort(p + 1, end, dataArr);
        }
        System.out.println("finally:");
        printNumbers(dataArr);
    }


    public void printNumbers(int[] dataArr) {
        for (int i = 0; i < dataArr.length; i++) {
            System.out.print(dataArr[i] + " ");
            System.out.println("");
        }
    }


    // 回文判断
    @Test
    public void testPalindrome() {

        char[] a = {'a', 'b', 'c', 'd', 'e', 'd', 'c', 'b', 'a'};
        char[] stack = new char[10];
        int top = 0;

        int mid = a.length / 2;

        for (int i = 0; i < mid; i++) {
            int tmp = a[i];
            stack[top++] = a[i];
        }

        boolean isPalindrome= true;
        for (int j = mid + 1; j < a.length-1; j++) {
            char left = a[j];
            char right = stack[top--];
            if (left==right) {
                isPalindrome=false;
                break;
            }
        }

        if (isPalindrome){
            System.out.println("the char arr is a Palindrome");
        }else {
            System.out.println("the char arr is not a Palindrome");
        }
    }

    //

}
