package com.itmei.offer;

/**
 * Created by qiaodan on 2017/12/27.
 */
public class BinaryTreeThree<T> extends BinaryTreeNodeThree<T> {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BinaryTreeThree(T data) {
        super.setData(data);
        this.count = 1;
    }

}
