package com.itmei.offer;

import java.util.Stack;

/**
 * Created by qiaodan on 2017/12/28.
 */
public class MyQueue<T> {
    // use 2 stacks implement a queue
    private Stack<T> stack1;
    private Stack<T> stack2;
    private int count = 0;

    public MyQueue() {
        this.stack1 = new Stack<T>();
        this.stack2 = new Stack<T>();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void queuein(T date) {
        while (!this.stack2.empty()) {
            this.stack1.push(stack2.pop());
        }
        this.stack1.push(date);
        ++this.count;
    }

    public T queueout() {
        if (this.stack1.isEmpty()&&this.stack2.isEmpty()){
            System.out.println("没有数据！");
            return null;
        }else {
            while (!this.stack1.isEmpty()) {
                this.stack2.push(this.stack1.pop());
            }
            --this.count;
            return this.stack2.pop();
        }
    }
}
