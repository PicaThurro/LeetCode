package com.tyj.树;

import com.tyj.TreeNode;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 * @author : 唐元晋
 * @created 2022/1/22 17:09
 */
public class _617_合并二叉树 {


    /**
     * 官方题解
     * 使用深度优先搜索合并两个二叉树。从根节点开始遍历两个二叉树，并将对应的节点进行合并。
     * 两个二叉树的对应节点可能存在以下三种情况，对于每种情况使用不同的合并方式。
     *      1.如果两个二叉树的对应节点都为空，则合并后的二叉树的对应节点也为空；
     *      2.如果两个二叉树的对应节点只有一个为空，则合并后的二叉树的对应节点其中的非空节点；
     *      3.如果两个二叉树的对应节点都不为空，则合并后的二叉树的对应节点的值两个二叉树的对应节点的值之和，此时需要显性合并两个节点
     * 对一个节点进行合并之后，还要对该节点的左右子树分别进行合并，这是一个递归的过程。
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
       if (t1==null){
           return t2;
       }
       if (t2==null){
           return t1;
       }
       TreeNode mergeTree=new TreeNode(t1.val+t2.val);
       mergeTree.left=mergeTrees(t1.left,t2.left);
       mergeTree.right=mergeTrees(t1.right,t2.right);
       return mergeTree;
    }


    /**
     * 自己写的辣鸡方法
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        TreeNode newRoot=new TreeNode(Integer.MIN_VALUE);
        TreeNode tail=newRoot;
        merge(root1,root2,tail);
        return newRoot.val==Integer.MIN_VALUE?null:newRoot;
    }

    public void merge(TreeNode root1,TreeNode root2,TreeNode newRoot){
        if (root1==null&&root2==null){
            return;
        }
        int ir1= root1!=null?root1.val:0;
        int ir2= root2!=null?root2.val:0;
        newRoot.val=ir1+ir2;
        merge(root1!=null?root1.left:null,root2!=null?root2.left:null,newRoot.left=new TreeNode(Integer.MIN_VALUE));
        merge(root1!=null?root1.right:null,root2!=null?root2.right:null,newRoot.right=new TreeNode(Integer.MIN_VALUE));
        if (newRoot.left.val==Integer.MIN_VALUE){
            newRoot.left=null;
        }
        if (newRoot.right.val==Integer.MIN_VALUE){
            newRoot.right=null;
        }
    }

}
