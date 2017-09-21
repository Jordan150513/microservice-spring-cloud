package com.itmei.chapter3;

/**
 * Created by qiaodan on 2017/9/15.
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread{
        public void run(){
            while (!ready){
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String args[]){
        new ReaderThread().start();
        number = 42;
        ready = true;
        // 两个线程 主线程 和 我自己定义的那个线程
    }
}
