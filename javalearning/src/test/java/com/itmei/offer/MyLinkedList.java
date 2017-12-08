package com.itmei.offer;

/**
 * Created by qiaodan on 2017/12/8.
 */
public class MyLinkedList<T> {
    int size;
    MyLinkedListNode<T> head;
    MyLinkedListNode<T> rear;

    public MyLinkedListNode<T> getRear() {
        return rear;
    }

    public void setRear(MyLinkedListNode<T> rear) {
        this.rear = rear;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public MyLinkedListNode<T> getHead() {
        return head;
    }

    public void setHead(MyLinkedListNode<T> head) {
        this.head = head;
    }

    public MyLinkedList() {
        this.size = 0;
        this.head= null;
        this.rear = null;
    }

    public MyLinkedList add(T t){
        MyLinkedListNode<T> node = new MyLinkedListNode<>(t);
        if (this.head==null){
            this.head = node;
            this.size = 1;
            this.rear = node;
            return this;
        }else {
            this.rear.next = node;
            this.rear = node;
            this.size = this.size+1;
            return this;
        }
    }

    public boolean isEmpty(){
        if (this.size==0&&this.head==null) return true;
        else return false;
    }

    public T getFirst(){
        if (this.head!=null&&this.size>0)
            return this.head.getData();
        else return null;
    }

    public boolean removeFirst(){
        if (this.head.next==null){
            this.head =null;
            this.size =0;
            return true;
        }else {
            this.head =  this.head.next;
            this.size= this.size-1;
            return true;
        }
    }
}
