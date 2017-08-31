package com.itmei.proxy;

/**
 * Created by qiaodan on 2017/8/22.
 */
public class LazyStudent implements Candidate {
    private String name;

    public LazyStudent(String name){
        this.name = name;
    }
    public void answerTheQuestions(){
        System.out.println(this.name);
        System.out.println("LazyStudent");

    }
}
