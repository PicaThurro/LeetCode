package com.tyj;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : 唐元晋
 * @created 2021/12/19 18:16
 */
public class TreeNode {

    public int val;
    public TreeNode right;
    public TreeNode left;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;

    }
}
