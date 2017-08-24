package com.itmei;

import com.sun.jmx.snmp.Timestamp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.sql.Struct;
import java.text.SimpleDateFormat;
import java.util.*;
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

        boolean isPalindrome = true;
        for (int j = mid + 1; j < a.length - 1; j++) {
            char left = a[j];
            char right = stack[top--];
            if (left == right) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("the char arr is a Palindrome");
        } else {
            System.out.println("the char arr is not a Palindrome");
        }
    }


    // 小猫钓鱼demo
    public void catFish() {
        int[] a = {2, 4, 1, 2, 5, 6};
        int[] b = {3, 1, 3, 5, 6, 4};



        int[] stack = new int[15];
        int top = 0;

        do {

        } while (a.length > 0 && b.length > 0);
    }


    // String 是不可变类  明明是可变的哇？
    @Test
    public void testString(){
        String string = "unmutable";
        System.out.println(string);
        string = string+" changed";
        System.out.println(string);
    }

    @Test
    public void testInteger(){
        System.out.println("refresh equal:");

        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);  // true
        System.out.println(f3 == f4);  //false

        System.out.println("Integer and int");

        Integer a = new Integer(3);
        Integer b = 3;
        int c = 3;
        System.out.println(a == b);
        System.out.println(a == c);
    }

    @Test
    public void testABHello(){
        A ab = new B();
        ab = new B();
        System.out.println(ab);
    }

    // binary search 二分查找
    @Test
    public void testBinarySearch(){
        System.out.println("binarySearch: ");
        Integer[] intArr = {1,2,3,4,5,7,22,30,39,44,67,90,123,245,678,1000};
        int location = binarySearch(intArr,22);
        System.out.println("location: "+location);
    }

    public <T extends Comparable<T>> int binarySearch(T[] x, T key) {
        return binarySearch(x, 0, x.length- 1, key);
    }

    public  <T extends Comparable<T>> int binarySearch(T[] x, int low, int high, T key) {
        if(low <= high) {
            int mid = low + ((high -low) >> 1);
            if(key.compareTo(x[mid])== 0) {
                return mid;
            }
            else if(key.compareTo(x[mid])< 0) {
                return binarySearch(x,low, mid - 1, key);
            }
            else {
                return binarySearch(x,mid + 1, high, key);
            }
        }
        return -1;
    }


     // while 循环实现  这个如何使用？
     public <T> int binarySearch(T[] x, T key, Comparator<T> comp) {
        int low = 0;
        int high = x.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = comp.compare(x[mid], key);
            if (cmp < 0) {
              low= mid + 1;
            }
            else if (cmp > 0) {
              high= mid - 1;
            }
            else {
              return mid;
            }
        }
        return -1;
     }

     // 测试 代理模式
     @Test
    public void testProxy(){
        LazyStudent lazyStudent = new LazyStudent("ergouzi");
        Gunman gunman = new Gunman(lazyStudent);
        gunman.answerTheQuestions();
     }


     @Test
    public void testEquals(){

         System.out.println("Object new String() equals and == ");
         Object s1 = new String("Hello");
         Object s2 = new String("Hello");

         if(s1 == s2) {
             System.out.println("s1 and s2 are ==");
         }else if (s1.equals(s2)) {
             System.out.println("s1 and s2 are equals()");
         }

         System.out.println("constant String equals and == ");

         Object s3 = "Hello";
         Object s4 = "Hello";

         if (s3 == s4) {
             System.out.println("s3 and s4 are ==");
         } else if (s3.equals(s4)) {
             System.out.println("s3 and s4 are equals()");
         }


     }
}
