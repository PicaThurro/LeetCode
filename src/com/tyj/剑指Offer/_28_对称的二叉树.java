package com.tyj.剑指Offer;

import com.tyj.TreeNode;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * @author : 唐元晋
 * @created 2021/12/27 22:10
 */
public class _28_对称的二叉树 {

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    //递归
    boolean recur(TreeNode L, TreeNode R) {
        //都为空时，返回true
        if(L == null && R == null) {
            return true;
        }
        //有一个越过叶子结点，或者两边值不相等，返回false
        if(L == null || R == null || L.val != R.val) {
            return false;
        }
        //递归调用
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

}
