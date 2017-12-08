package com.itmei.offer;

/**
 * Created by qiaodan on 2017/12/8.
 */
public class BinaryTree<T> extends BinaryTreeNode<T> {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BinaryTree(T data) {
        super(data);
        this.count = 1;
    }
}
