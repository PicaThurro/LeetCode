package com.tyj.树;

import com.tyj.TreeNode;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * @author : 唐元晋
 * @created 2022/1/22 16:41
 */
public class _543_二叉树的直径 {

    /**
     * 两个叶子结点之间的路径=跟结点左右儿子的深度之和
     */
    int maxd=0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return maxd;
    }

    public int diameter(TreeNode root){
        if (root==null){
            return 0;
        }
        int left=diameter(root.left);
        int right=diameter(root.right);
        //保存当前节点的直径
        maxd=Math.max(left+right,maxd);
        return Math.max(left,right)+1;
    }
}
