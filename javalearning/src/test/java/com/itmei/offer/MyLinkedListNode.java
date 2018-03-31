package com.itmei.offer;

/**
 * Created by qiaodan on 2017/12/8.
 */
public class MyLinkedListNode<T> {
    T data;
    MyLinkedListNode<T> next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MyLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(MyLinkedListNode<T> next) {
        this.next = next;
    }

    public MyLinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }


}
