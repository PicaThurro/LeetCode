package com.tyj.剑指Offer;

import com.tyj.TreeNode;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * @author : 唐元晋
 * @created 2021/12/20 23:28
 */
public class _32_Ⅰ从上到下打印二叉树 {

    public static void main(String[] args) {
        TreeNode head=new TreeNode(3);
        head.left=new TreeNode(9);
        head.right=new TreeNode(20);
        TreeNode right=head.right;
        right.left=new TreeNode(15);
        right.right=new TreeNode(7);
        int[] ints = levelOrder(head);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public static int[] levelOrder(TreeNode root) {
        if (root==null){
            return new int[]{};
        }
        Queue<TreeNode> queue=new LinkedList<>();
        Queue<Integer> queue2=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            queue2.offer(poll.val);
            if (poll.left!=null){
                queue.offer(poll.left);
            }
            if (poll.right!=null){
                queue.offer(poll.right);
            }
        }
        int[] ints =new int[queue2.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i]=queue2.poll();
        }

        return ints;
    }

}
