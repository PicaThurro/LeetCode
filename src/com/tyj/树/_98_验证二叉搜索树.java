package com.tyj.树;

import com.tyj.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @author : 唐元晋
 * @created 2022/1/23 13:48
 */
public class _98_验证二叉搜索树 {


    /**
     * 利用中序遍历得到一个数组
     * 如果这颗二叉树是二叉树搜索树的话，那中序遍历得到的数组必然是升序的顺序
     * 只要遍历数组判断，如果i的元素大于等于i+的元素那就不是二叉搜索树，直接返回false
     * (注意上面的判断里是大于等于，题意是当前节点只能比左子树大，并且比右子树小,有重复元素就不符合题目要求，所以判断等于的情况)
     * 时间复杂度和空间复杂度都是 O(n)  n是树的节点个数
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }
        List<Integer> list=new ArrayList<>();
        mediumOrderTraversal(root,list);
        for (int i = 0; i+1 < list.size(); i++) {
            if (list.get(i)>=list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public void mediumOrderTraversal(TreeNode root, List<Integer> list){
        if (root==null){
            return;
        }
        mediumOrderTraversal(root.left,list);
        list.add(root.val);
        mediumOrderTraversal(root.right,list);
    }

    /**
     * 不好理解，且性能较差
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root==null){
            return true;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            boolean leftTreeIsBST=true;
            boolean rightTreeIsBST=true;
            if (node.left!=null){
                leftTreeIsBST = leftSearch(node.left, node.val);
                queue.offer(node.left);
            }
            if (node.right!=null){
                rightTreeIsBST = rightSearch(node.right, node.val);
                queue.offer(node.right);
            }
            if (leftTreeIsBST&&rightTreeIsBST){
            }else {
                return false;
            }
        }

        return true;
    }

    public boolean leftSearch(TreeNode node,int rootValue){
        if (node==null){
            return true;
        }
        if (node.val>=rootValue){
            return false;
        }
        return leftSearch(node.left,rootValue)&&leftSearch(node.right,rootValue);
    }


    public boolean rightSearch(TreeNode node,int rootValue){
        if (node==null){
            return true;
        }
        if (node.val<=rootValue){
            return false;
        }
        return rightSearch(node.left,rootValue)&&rightSearch(node.right,rootValue);
    }

}
