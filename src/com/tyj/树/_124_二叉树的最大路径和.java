package com.tyj.树;

import com.tyj.TreeNode;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * @author : 唐元晋
 * @created 2022/1/29 17:22
 */
public class _124_二叉树的最大路径和 {

    int max=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        optimalSum(root);
        return max;
    }

    public int optimalSum(TreeNode root){
        if (root==null){
            return 0;
        }
        //左右节点的值要大于0才选取
        int left=optimalSum(root.left);
        left=Math.max(0, left);
        int right=optimalSum(root.right);
        right=Math.max(0,right);
        //根加上左右节点的和更新一下答案
        int sum=left+right+root.val;
        max=Math.max(max,sum);

        //返回当前root加上其中一个节点值最大的和
        return root.val+Math.max(left,right);
    }

}
