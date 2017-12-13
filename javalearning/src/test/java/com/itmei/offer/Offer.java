package com.itmei.offer;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

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
     * 问题3、考察正则表达式的使用 还是写不出来 缺少练习 String 中的正则替换，分隔金额数字
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
        String result2 = num2.replaceAll(pattern2, "$1" + ",");
        System.out.println(result2);
    }

    /**
     * 问题4、二维数组（有序，同行从小到大，同列从小到大）中查找某个数值 是否在二维数组中
     */
    @Test
    public void findNuminMactrix() {
        int[][] matrix1 = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int target = 7; // 存在的数据 和不存在的数据 都可以正常返回！
        int row = matrix1.length;
        int col = matrix1[1].length;
        int startrow = 0;
        int startcol = 0;
        int endrow = row - 1;
        int endcol = col - 1;

        // 缩小列范围
        while (startcol < endcol && matrix1[1][endcol] > target)
            endcol--;
        while (startcol < endcol && matrix1[row - 1][startcol] < target)
            startcol++;

        while (startrow < endrow && matrix1[startrow][endcol] < target)
            startrow++;
        while (startrow < endrow && matrix1[endrow][endcol] > target)
            endrow--;

        if (matrix1[startrow][startcol] == target) {
            System.out.println("target :" + target + " 坐标是： " + "(" + startrow + "," + startcol + ")");
        } else System.out.println("没有找到");
    }

    /**
     * 问题5、String中的空格替换 将string中的空格替换成%20
     */
    @Test
    public void replaceSpace() {
        // 1、将每一个空格 替换成 另外一个/串 字符
        // 2、将一个或者多个空格 替换成 一个/串 字符
        String content = "we are  happy!";
        String regx = "\\s";
        String result = content.replaceAll(regx, "%20");
        System.out.println(result);
    }

    /**
     * 问题6、有序数组 A1 A2 的合并
     */
    @Test
    public void orderArrayMerge() {
        // 两个有序数组 A1 A2 的合并
        int[] A1 = {1, 5, 7, 8, 9, 12, 20, 39, 0, 0, 0, 0, 0, 0, 0};
        int[] A2 = {3, 5, 7, 13, 15, 23, 45};
        int A1A2Index = A1.length - 1;
        int A1Rear = A1.length - A2.length - 1;
        int A2Rear = A2.length - 1;
        while (A2Rear >= 0 && A1Rear >= 0) {
            if (A2[A2Rear] > A1[A1Rear]) {
                // 要插入的数据 可以直接插入
                A1[A1A2Index] = A2[A2Rear];
                A2Rear--;
            } else {
                // 要插入的数据 需要往前插入
                A1[A1A2Index] = A1[A1Rear];
                A1Rear--;
            }
            A1A2Index--;
        }
        for (int num : A1) {
            System.out.println(num);
        }
    // 总结 需要挪动数据的插入 要从后往前插入 时间复杂度0（n）
    }

    /**
     *  问题7、从尾到头打印列表 用jdk的LinkList
     *
     */
    @Test
    public void print_reverse_LinkedList(){
        LinkedList<Person> list = new LinkedList<Person>();
        for (int i =5;i>0;i--){
            Person p1 = new Person();
            p1.setName("Alice"+i);
            p1.setAge(10+i);
            list.add(p1);
        }

        // 利用栈 实现逆序打印链表的内容
        Stack<Person> stack = new Stack<Person>();
        while (!list.isEmpty()){
            Person p2 = list.getFirst();
            list.removeFirst();
            stack.push(p2);
        }

        while (!stack.isEmpty()){
            Person p = stack.pop();
            System.out.println(p.toString());
        }
        // jdk 的 LinkedListu 执行递归打印 链表的最后一个数据 不方便 在自定义的地方进行递归操作
    }

    /**
     *  问题8、从尾到头打印列表 自定义的MyLinkList 有next指针 可以直接用递归的方式来打印链表
     *
     */
    @Test
    public void print_reverse_MyLinkedList() {
        MyLinkedList<Person> list = new MyLinkedList<>();
        for (int i = 5; i > 0; i--) {
            Person p1 = new Person();
            p1.setName("Alice" + i);
            p1.setAge(10 + i);
            list.add(p1);
        }

        // 利用栈 实现逆序打印链表的内容
//        Stack<Person> stack = new Stack<Person>();
//        while (!list.isEmpty()) {
//            Person p2 = list.getFirst();
//            list.removeFirst();
//            stack.push(p2);
//        }
//        while (!stack.isEmpty()){
//            Person p = stack.pop();
//            System.out.println(p.toString());
//        }

        // 利用递归来打印
        if (list==null){
            System.out.println("链表为空！");
        }else {
            print_reverse_MyLinkedList(list.head);
        }

    }

    // 递归动作 这里还有一个问题 为什么没有按照预期 倒叙打印 反而只打印了链表的尾部 一个else的区别 递归打印下面的元素之后 回来要打印自己！
    public void print_reverse_MyLinkedList(MyLinkedListNode head){
        if (head.next!=null)
            this.print_reverse_MyLinkedList(head.next);
         System.out.println(head.getData().toString());
    }

    /**
     * 问题8、根据根据前序遍历和中序遍历 确定 构造一个 二叉树
     */
    @Test
    public void contructionBinaryTree(){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] middle = {4,7,2,1,5,3,8,6};
        int root = 0;
        int startL = 0;
        int endL = foundNumIndexinMiddle(pre[root],middle)-1;
        int startR = foundNumIndexinMiddle(pre[root],middle)+1;
        int endR = middle.length-1;
        Person rootPerson = new Person();
        int val = pre[root];
        System.out.println(val);
        rootPerson.setName("node"+pre[root]);
        rootPerson.setAge(pre[root]);
        BinaryTree<Person> tree = new BinaryTree<Person>(rootPerson);
        tree.setCount(pre.length);
        root++;// 这里不严谨 还需要跟递归里面一样增加判断 单叉树 等等测试用例的验证
        tree.setLeft(constructBTCore(root,startL,endL,middle,pre));
        root = startR;
        if (startR==endR){
            root++;
        }
        tree.setRight(constructBTCore(root,startR,endR,middle,pre));
        System.out.println(tree.getLeft().getData().getName());
        System.out.println(tree.getRight().getData().getName());
    }

    public BinaryTreeNode<Person> constructBTCore(int rootindex,int start,int end,int[] middle,int[] pre){

        Person p = new Person();
        p.setName("node"+pre[rootindex]);
        p.setAge(pre[rootindex]);
        BinaryTreeNode<Person> tree = new BinaryTreeNode<>(p);
        tree.setLeft(null);
        tree.setRight(null);

        int startL = start;
        int endL = foundNumIndexinMiddle(pre[rootindex],middle)-1;
        int startR = foundNumIndexinMiddle(pre[rootindex],middle)+1;
        int endR = end;
        if (start<end && rootindex<pre.length) {
            if (startL <= endL&&startL>=start) {
                rootindex++;
                tree.setLeft(constructBTCore(rootindex, startL, endL, middle, pre));
            }

            if (startR < endR && rootindex<pre.length&&endR<=end) {
                rootindex = startR;
                tree.setRight(constructBTCore(rootindex, startR, endR, middle, pre));
            } else if(startR==endR){
                rootindex++;
                tree.setRight(constructBTCore(rootindex, startR, endR, middle, pre));
            }
        }
        return tree;
    }

    public int foundNumIndexinMiddle(int num,int[] arr){

        for (int i=0;i<arr.length;i++){
            if (arr[i]==num)
                return i;
        }
        return 0;
    }

    /**
     * 问题 9、一个有数组 里面有奇数偶数，将奇数和偶数分开，并且奇数的相对顺序不能改变 偶数的相对顺序也不能改变 不允许创建新的数组 空间复杂度为O(1)
     */
    @Test
    public void seperateOddEven(){
        // 准备将奇数放在前面 偶数放在后面
        int[] a = {3,5,6,2,8,12,14,9,21,16,13};
        for (int i =0;i<a.length;i++){
            if (a[i]%2==1){
                // 是奇数
                continue;
            }
            // 找到了第一个偶数 然后再找到第一个偶数后面的第一个奇数
            int j = i+1;
            while (j<a.length&&a[j]%2==0){
                j++;
            }
            if (j==a.length) break;
            int tmp = a[j];
            // 然后将 i--> j-1 的元素 全部向后移动
            a = drawback(i,j,a);
            a[i]= tmp;
        }
        for (int num:a){
            System.out.println(num);
        }
    }

    // 将指定范围的字符进行后移
    public int[] drawback(int start,int end,int[] a){
        while (end>=start){
            a[end] = a[end-1];
            end--;
        }
        return a;
    }

}
