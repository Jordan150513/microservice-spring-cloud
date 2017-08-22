package com.itmei;

/**
 * Created by qiaodan on 2017/8/22.
 */
public class Gunman implements Candidate {
    private Candidate candidate;
    public Gunman(Candidate candidate){
        this.candidate = candidate;
    }
    public void answerTheQuestions(){
        this.candidate.answerTheQuestions();
        // 枪手自己作答
        System.out.println("i am the gunman");
    }
}
