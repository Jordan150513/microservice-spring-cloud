package com.itmei.leetcode;

/**
 * @Description 二叉树结构
 * @Auther qiaodan
 * @Date 2018/9/19 上午11:12
 * @Version 1.0
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

//    public int getVal() {
//        return val;
//    }
//
//    public void setVal(int val) {
//        this.val = val;
//    }
//
//    public TreeNode getLeft() {
//        return left;
//    }
//
    public void setLeft(TreeNode left) {
        this.left = left;
    }
//
//    public TreeNode getRight() {
//        return right;
//    }
//
    public void setRight(TreeNode right) {
        this.right = right;
    }
}
