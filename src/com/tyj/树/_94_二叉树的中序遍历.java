package com.tyj.树;

import com.tyj.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @author : 唐元晋
 * @created 2021/12/19 18:16
 */
public class _94_二叉树的中序遍历 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        serach(root,result);
        return result;
    }

    public static void serach(TreeNode root, List<Integer> result){
        if(root==null){
            return;
        }
        serach(root.left,result);
        result.add(root.val);
        serach(root.right,result);
    }

}
