package com.itmei.leetcode;

import org.junit.Test;

import java.util.*;

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

    @Test
    public void testCollectionSort(){
        List<String> stringslist = Arrays.asList("6", "1", "3", "1","2");

        Collections.sort(stringslist);//sort方法在这里

        for (String string : stringslist) {

            System.out.println(string);
        }
    }

    // LinkedHashMap 的访问顺序会改变 LinkedHashMap 的数据结构存储，遍历顺序会按照访问的顺序
    @Test
    public void testLinkedHashMap(){
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<String,String>(16,0.75f,true);
        linkedHashMap.putIfAbsent("no1","wang");
        linkedHashMap.put("no2","z");
        linkedHashMap.put(null,"zhang");
        linkedHashMap.putIfAbsent("no3","li");
        linkedHashMap.putIfAbsent("no4","zheng");
        linkedHashMap.put("no5","zhang");
        linkedHashMap.put(null,"zhang");
        linkedHashMap.put("no6","666");
        linkedHashMap.forEach((k,v)->
                System.out.println(k+":"+v)
        );
        linkedHashMap.get("no1");
        linkedHashMap.forEach((k,v)->
                System.out.println(k+":"+v)
        );
    }

}
