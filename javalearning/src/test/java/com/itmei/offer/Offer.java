package com.itmei.offer;

import org.junit.Test;

import java.util.HashSet;

/**
 * Created by qiaodan on 2017/12/6.
 */
public class Offer {

    /**
     * 问题1、：找出数组中的重复的数字，数组长度是n，数组中的数据范围0 -- n-1
     * 另外：代码要做好验证，边界处理，要满足各种测试用例！！
     */

    @Test
    public void dumplicateNumInArr() {
        int nums[] = {1, 2, 0, 0, 2, 4, 3, 1, 5, 7, 9, 9};
        HashSet<Integer> dumSet = new HashSet<Integer>();
        // 空间复杂度为o(1)的方法：
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                // 不在自己的位置上
                if (nums[nums[i]] == nums[i]) {
                    // 自己的位置上 已经有自己 就重复了
                    System.out.println("dumplicate: " + nums[i]);
                    dumSet.add(nums[i]);
                    break;
                } else {
                    // 自己的位置上 不是自己 就交换
                    int tmp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = tmp;
                }
            }
        }

        if (dumSet.size() > 0) {
            System.out.println("重复的集合：");
            for (int num : dumSet) {
                System.out.println(num);
            }

        }
    }

    /**
     * 问题2:、 不修改数组 找出重复的数字
     * 使用辅助空间的方法很常规，空间复杂度为o(n)
     * 如何不修改原始数组，也不使用额外的辅助空间的方法？
     */

    @Test
    public void dumplicateArr2() {

        // 长度为8的数组，里面的数据范围是1-7 所以肯定有冗余重复的数据，要找出这些数据
        // 这个不能保证找到所有的重复的数据，只能找到一个
        int nums[] = {2, 3, 5, 4, 3, 2, 6, 7};
        int total = nums.length;
        int start = 1;
        int end = nums.length - 1;
        HashSet<Integer> dumpSet = new HashSet<Integer>();
        while (end >= start) {
            int middle = (end - start) / 2 + start;
            int count = countInArr(start, middle, nums);
            if (end == start) {
                if (count > 1) {
                    System.out.println("重复数据： " + nums[end]);
                    dumpSet.add(nums[start]);
                    // 只能找到一个重复的数据，不能保证找到所有重复的数据
                    return;
                } else break;
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        if (dumpSet.size() > 0) {
            for (int u : dumpSet) {
                System.out.println(u);
            }
        }

    }

    /**
     * from to 范围内的数字有多少个？
     *
     * @param fromNum
     * @param toNum
     * @param array
     * @return
     */
    public int countInArr(int fromNum, int toNum, int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= fromNum && array[i] <= toNum) {
                count++;
            }
        }
        return count;
    }


    /**
     * 考察正则表达式的使用 还是写不出来 缺少练习
     */
    @Test
    public void reviewPattern() {
        // 对字符串做处理，从后往前数 每三个 加一个“，” 间隔 并打印出来

//        String num1 = "123ttt7801";
//        // 匹配3个数字的正则表达式
//        String pattern = "(\\d{3})";
//        String result = num1.replaceAll(pattern, "a");
//        System.out.println(result);

        // 正向预查 后面边界的条件 和 非条件的混合
        // 反向预查 是开始的边界的 条件 和非条件
        String num2 = "123456780";
        String pattern2 = "(\\d)(?=(\\d{3})+(?!\\d))";
       String result2 =  num2.replaceAll(pattern2,"$1"+",");
        System.out.println(result2);
    }

    @Test
    public void findNuminMactrix(){
        int[][] matrix1 = {{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
        int target = 7; // 存在的数据 和不存在的数据 都可以正常返回！
        int row = matrix1.length;
        int col = matrix1[1].length;
        int startrow = 0;
        int startcol = 0;
        int endrow = row-1;
        int endcol = col-1;

        // 缩小列范围
        while (startcol<endcol&&matrix1[1][endcol]>target)
                endcol--;
        while (startcol<endcol&&matrix1[row-1][startcol]<target)
            startcol++;

        while (startrow<endrow&&matrix1[startrow][endcol]<target)
            startrow++;
        while (startrow<endrow&&matrix1[endrow][endcol]>target)
            endrow--;

        if (matrix1[startrow][startcol]==target){
            System.out.println("target :"+target+" 坐标是： "+"("+startrow+","+startcol+")");
        }else System.out.println("没有找到");

    }
}
