package com.tyj.树;

import com.tyj.TreeNode;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * @author : 唐元晋
 * @created 2022/2/8 16:44
 */
public class _538_把二叉搜索树转换为累加树 {

    /**
     * 反中序遍历
     * 用一个成员变量不断累加更新每个节点的val
     */
    int sum=0;

    public TreeNode convertBST(TreeNode root) {
        if (root==null){
            return null;
        }
        convertBST(root.right);
        sum+=root.val;
        root.val=sum;
        convertBST(root.left);
        return root;
    }

}
