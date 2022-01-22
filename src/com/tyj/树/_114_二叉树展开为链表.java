package com.tyj.树;

import com.tyj.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * @author : 唐元晋
 * @created 2022/1/22 18:07
 */
public class _114_二叉树展开为链表 {


    /**
     * 官方题解 寻找前驱节点
     * 对于当前节点，如果其左子节点不为空，则在其左子树中找到最右边的节点，作为前驱节点
     * 将当前节点的右子节点赋给前驱节点的右子节点，然后将当前节点的左子节点赋值给当前节点的右子节点
     * 并将当前节点的左子节点设为空
     * 对当前节点处理结束后，继续处理链表中的下一个节点，直到所有节点都处理结束
     * @param root
     */
    public void flatten(TreeNode root){
       TreeNode curr=root;
       while (curr!=null){
           //如果curr的左子树不为空，就进入左子树查找它的前驱节点
           if (curr.left!=null){
               TreeNode next=curr.left;
               TreeNode predecessor=next;
               while (predecessor.right!=null){
                   predecessor=predecessor.right;
               }
               //curr的右子树放到前驱节点的右子树
               predecessor.right=curr.right;
               //curr的左子树设为空
               curr.left=null;
               //curr的右子树设为之前临时保存的curr的左子树
               curr.right=next;
           }
           //下一轮循环
           curr=curr.right;
       }
    }


    /**
     * 先序遍历一次把值存入list，先序遍历正好是按照顺序把值存入list。先序遍历的时候可以顺带把每个节点的left清空
     * 然后遍历list依次把值放入node.right，从下标1开始，因为根节点的值不需要动
     *  需要判断一下node的right是否为空，如果为空就新建一个节点，再把值放入
     * @param root
     */
    public void flatten2(TreeNode root) {
        if (root==null){
            return;
        }
        List<Integer> list=new ArrayList<>();
        TreeNode temp=root;
        preorderTraversal(temp,list);
        temp=root;
        for (int i = 1; i < list.size(); i++) {
            if (temp.right==null){
                temp.right=new TreeNode();
            }
            temp.right.val=list.get(i);
            temp=temp.right;
        }
    }

    public void preorderTraversal(TreeNode root, List<Integer> list){
        if (root==null){
            return;
        }
        list.add(root.val);
        preorderTraversal(root.left,list);
        preorderTraversal(root.right,list);
        root.left=null;
    }

}
