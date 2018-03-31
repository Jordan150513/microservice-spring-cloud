package com.itmei.leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by qiaodan on 2018/3/29.
 */
public class MaiMaiQA {
//    Collection<Integer>;
//    List<Integer>
//Set
//    Map
//    ListIterator<E>
    @Test
        public void testHashMap(){
        try {
            HashMap<String,Integer> map = new HashMap<String,Integer>(10);
            for (int i=0;i<20;i++){
              Integer rs =   map.put("jack"+i,100+i);
                System.out.println(map);
            }
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
            System.out.println("------"+e.getMessage());
        }

    }


}
