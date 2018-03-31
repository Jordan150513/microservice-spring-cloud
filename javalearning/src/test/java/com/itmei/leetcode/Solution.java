package com.itmei.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by qiaodan on 2018/3/12.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;

        int sum =  l1.val+l2.val;
        ListNode head = new ListNode(sum%10);
        head.next = null;
        ListNode rear = head;

        int overflow = sum/10;
        ListNode p = l1.next;
        ListNode q = l2.next;
        while(p!=null||q!=null){

            if(p!=null&&q!=null){
                sum =  p.val+q.val+overflow;
                p=p.next;
                q=q.next;
            }else if(p==null&&overflow==1){
                sum =  q.val+overflow;
                p=null;
                q=q.next;
            }else if(q==null&&overflow==1){
                sum =  p.val+overflow;
                p=p.next;
                q=null;
            }
            else if(p==null&&overflow==0){
                rear.next = q;
                return head;
            }else if(q==null&&overflow==0){
                rear.next = p;
                return head;
            }
            overflow = sum/10;
            ListNode tmp = new ListNode(sum%10);
            tmp.next = null;
            rear.next = tmp;
            rear = tmp;
        }
        if (overflow==1){
            ListNode tmp = new ListNode(overflow);
            tmp.next = null;
            rear.next = tmp;
            rear = tmp;
        }

        return head;
    }

    @Test
    public void testAddTwoNumbers(){
        ListNode l1 = new ListNode(5);
        l1.next = null;
        ListNode l2 = new ListNode(5);
        l2.next = null;
        ListNode rs = addTwoNumbers(l1,l2);
    }

// 找到最长的没有重复的子串
    public int lengthOfLongestSubstring(String s) {
        return 1;
    }

    @Test
    public void  testlengthOfLongestSubstring(){
        String str = "abcabcbb";
       int rs =  lengthOfLongestSubstring(str);
       System.out.println(rs);
    }

    // KMP
    void cal_next(char[] str, int[] next, int len)
    {
        next[0] = -1;//next[0]初始化为-1，-1表示不存在相同的最大前缀和最大后缀
        int k = -1;//k初始化为-1
        for (int q = 1; q <= len-1; q++)
        {
            while (k > -1 && str[k + 1] != str[q])//如果下一个不同，那么k就变成next[k]，注意next[k]是小于k的，无论k取任何值。
            {
                k = next[k];//往前回溯
            }
            if (str[k + 1] == str[q])//如果相同，k++
            {
                k = k + 1;
            }
            next[q] = k;//这个是把算的k的值（就是相同的最大前缀和最大后缀长）赋给next[q]
        }
    }

    int KMP(char[] str, int slen, char[] ptr, int plen)
    {
    int[] next = new int[plen];
        cal_next(ptr, next, plen);//计算next数组
        int k = -1;
        for (int i = 0; i < slen; i++)
        {
            while (k >-1&& ptr[k + 1] != str[i])//ptr和str不匹配，且k>-1（表示ptr和str有部分匹配）
                k = next[k];//往前回溯
            if (ptr[k + 1] == str[i])
                k = k + 1;
            if (k == plen-1)//说明k移动到ptr的最末端
            {
                //cout << "在位置" << i-plen+1<< endl;
                //k = -1;//重新初始化，寻找下一个
                //i = i - plen + 1;//i定位到该位置，外层for循环i++可以继续找下一个（这里默认存在两个匹配字符串可以部分重叠），感谢评论中同学指出错误。
                return i-plen+1;//返回相应的位置
            }
        }
        return -1;
    }

    @Test
    public void testKMP(){
        char[] str = "bacbababadababacambabacaddababacasdsd".toCharArray();
        char[] ptr = "ababaca".toCharArray();
        int a = KMP(str, 36, ptr, 7);
        System.out.println(a);
    }
    // I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）
        /*
        * 1、重复数次：一个罗马数字重复几次，就表示这个数的几倍。
2、右加左减：
2.1 在较大的罗马数字的右边记上较小的罗马数字，表示大数字加小数字。
2.2 在较大的罗马数字的左边记上较小的罗马数字，表示大数字减小数字。
2.3 左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV
2.4 但是，左减时不可跨越一个位数。比如，99不可以用IC（100 - 1）表示，而是用XCIX（[100 - 10] + [10 - 1]）表示。（等同于阿拉伯数字每位数字分别表示。）
2.5 左减数字必须为一位，比如8写成VIII，而非IIX。
2.6 右加数字不可连续超过三位，比如14写成XIV，而非XIIII。（见下方“数码限制”一项。）

3、加线乘千：
3.1 在罗马数字的上方加上一条横线或者加上下标的Ⅿ，表示将这个数乘以1000，即是原数的1000倍。
3.2 同理，如果上方有两条横线，即是原数的1000000（1000^{2}）倍。

4、数码限制：
4.1 同一数码最多只能出现三次，如40不可表示为XXXX，而要表示为XL。
4.2 例外：由于IV是古罗马神话主神朱庇特（即IVPITER，古罗马字母里没有J和U）的首字，因此有时用IIII代替
*/

    public int romanToInt(String s) {

        HashMap map = new HashMap();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i=0;i<s.length();i++){
            String key = s.substring(i,i+1);
            int value = (new Integer(map.get(key).toString())).intValue();
            if (key.equals("I")||key.equals("X")||key.equals("C")){
                // 左减的数字有限制，仅限于I、X、C
                if (i+1<s.length()){
                    //还有右边
                    String keynext = "";
                    if (i+2<s.length()){
                         keynext = s.substring(i+1,i+2);
                    }else {
                        keynext = s.substring(i+1);
                    }
                    if(new Integer(map.get(keynext).toString()).intValue()>new Integer(map.get(key).toString()).intValue()){
                         value = -(new Integer(map.get(key).toString())).intValue();
                        arrayList.add(i,value);
                    }else arrayList.add(i,value);
                }else arrayList.add(i,value);
            }else
                arrayList.add(i,value);
        }
        int rs = 0;
        for (int i=0;i<arrayList.size();i++){
            rs = rs+arrayList.get(i);
        }
        return rs;
    }

    @Test
    public void  testRomanToInt(){
        // XLV
        // DCXXI
        int rs = romanToInt("DCXXI");
        System.out.println(rs);
    }

    // 寻找最大的前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) return "";
        int minLength = strs[0].length();
        boolean flage = true;
        for (int i=0;i<strs.length;i++){
            if (strs[i].length()<minLength)
                minLength =  strs[i].length();
        }
        if(minLength==0) return "";
        int index = minLength;
        for (int i=0;i<minLength&&flage;i++){
            String sample = "";
            if (i+1<=minLength){
                sample = strs[0].substring(0,i+1);
            }else {
                sample = strs[0].substring(0);
            }

            for (String item:strs){
                String tm = "";
                if (i+1<=item.length()){
                    tm = item.substring(0,i+1);
                }else {
                    tm = item.substring(0);
                }
                if (!tm.equals(sample)){
                    index = i;
                    flage = false;
                    break;
                }
            }
        }

        String rs = strs[0].substring(0,index);
        return rs;
    }

    @Test
    public void testlongestCommonPrefix(){
        String[] strs = {"flower","flow","flight"};
        String rs = longestCommonPrefix(strs);
        System.out.println(rs);
    }

    public boolean isValid(String s) {
        if (s==null) return false;
        if (s.isEmpty()) return true;
//        '('=40 , ')'=41 , '{'=123, '}'=125, '['=91,  ']'=93

        Stack<String> stack = new Stack<String>();
        for (int i=0;i<s.length();i++){
            char a = s.charAt(i);
            switch (a){
                case '{':
                case '(':
                case '[':
                    {
                        stack.push(String.valueOf(a));
                        break;
                    }
                case '}':
                    {
                        if (stack.isEmpty()){
                            return false;
                        }
                        char c = stack.pop().charAt(0);
                        if (c!='{'){
                            return false;
                        }
                        break;
                    }
                case ')':
                {
                    if (stack.isEmpty()){
                        return false;
                    }
                    char c = stack.pop().charAt(0);
                    if (c!='('){
                        return false;
                    }
                    break;
                }
                case ']':
                    {
                        if (stack.isEmpty()){
                            return false;
                        }
                    char c = stack.pop().charAt(0);
                    if (c!='['){
                        return false;
                    }
                    break;
                }

            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }

    @Test
    public void testIsValid(){
        String s = "{";
        boolean rs = isValid(s);
        System.out.println(rs);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null&&l2==null) return null;
        if (l1==null) return l2;
        if (l2==null) return l1;
        ListNode rs = null;
        ListNode rear = rs;
        while (l1!=null&&l2!=null){
                if(l1.getVal()<=l2.getVal()){
                    if (rs==null)
                    {
                        rs = l1;
                        rear = rs;
                    }else {
                        rear.setNext(l1);
                        rear = l1;
                    }
                    l1 = l1.next;
                    continue;
                }

                if(l1.getVal()>l2.getVal()){
                    if (rs==null)
                    {
                        rs = l2;
                        rear = rs;
                    }else {
                        rear.setNext(l2);
                        rear = l2;
                    }
                    l2 = l2.next;
                    continue;
                }
            }
        if(l1!=null){
            rear.next = l1;
        }else {
            rear.next = l2;
        }
        return rs;
    }

    @Test
    public void testMergeTwoLists(){
//[1,2,4]
//[1,3,4]
        int[] a = {1,2,4};
        int[] b = {1,3,4};

        ListNode item3 = new ListNode(4);
        ListNode item2 = new ListNode(2);
        item2.setNext(item3);
        ListNode alist = new ListNode(1);
        alist.setNext(item2);

        ListNode blist = new ListNode(1);
        blist.setNext(new ListNode(3));
        blist.getNext().setNext(new ListNode(4));
       ListNode rs =  mergeTwoLists(alist,blist);
       while (rs!=null){
           System.out.println(rs.getVal());
           rs = rs.getNext();
       }
    }

    public int removeDuplicates(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int pre = 0;// pre是下标
        int i;
        for (i=1;i<nums.length;i++){
            if (nums[pre]==nums[i]) continue;
            if (nums[pre]<nums[i]){
                pre++;
                if (i-pre>0){
                    nums[pre] = nums[i];
                }
            }
        }
        return pre+1;//需要返回长度
    }

    @Test
    public void testRemoveDuplicates(){
        int[] nums = {1,1,2,3,4,5,6,6};
      int rs =   removeDuplicates(nums);
      System.out.println(rs);
    }

    public int removeElement(int[] nums, int val) {
        if (nums==null||nums.length==0) return 0;
        int length = nums.length;
        int j=nums.length-1;
        for (int i =0;i<nums.length;i++){
            if (nums[i]==val){
                length--;
                while (j>i&&nums[j]==val)
                    j--;
                if (j>i){
                    int tmp =  nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    j--;
                    length++;
                }
            }
        }
        return length;
    }

    @Test
    public void testRemoveElement(){
        int[] nums = {3,1,3,3,3};
        int value = 3;
        int rs = removeElement(nums,value);
        System.out.println(rs);
    }

}
