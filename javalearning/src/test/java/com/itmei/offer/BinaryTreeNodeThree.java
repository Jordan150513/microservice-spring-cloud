package com.itmei.offer;

/**
 * Created by qiaodan on 2017/12/27.
 */
public class BinaryTreeNodeThree<T> extends BinaryTreeNode<T> {
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
        super.setData(data);
        return;
    }
}
