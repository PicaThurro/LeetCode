package com.tyj.树;

import com.tyj.TreeNode;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * @author : 唐元晋
 * @created 2021/12/27 23:00
 */
public class _110_平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        int left = checkHigh(root.left);
        int right = checkHigh(root.right);
        return Math.abs(left-right)>1?false:true&&isBalanced(root.left)&&isBalanced(root.right);
    }

    public int checkHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(checkHigh(root.left), checkHigh(root.right));
    }


}
