package com.itmei.leetcode;

import org.junit.Test;

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
}
