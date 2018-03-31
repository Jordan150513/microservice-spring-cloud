package com.itmei.offer;

/**
 * Created by qiaodan on 2017/12/27.
 */
public class BinaryTreeNodeThree<T>{
    private T data;
    private BinaryTreeNodeThree<T> left;
    private BinaryTreeNodeThree<T> right;

    public BinaryTreeNodeThree<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNodeThree<T> left) {
        this.left = left;
    }

    public BinaryTreeNodeThree<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNodeThree<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private BinaryTreeNodeThree<T> parentimp;
    // 发现一个问题 有子类的时候 父类一定要有 默认的空的构造方法？？？ 有这样的报错 是这样嘛？


    public BinaryTreeNodeThree<T> getParentimp() {
        return parentimp;
    }

    public void setParentimp(BinaryTreeNodeThree<T> parentimp) {
        this.parentimp = parentimp;
    }

    public BinaryTreeNodeThree(){
        return;
    }

    public BinaryTreeNodeThree(T data) {
        this.data = data;
    }
}
