package com.tyj.剑指Offer;

import com.tyj.TreeNode;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * @author : 唐元晋
 * @created 2021/12/20 23:48
 */
public class _32_Ⅱ从上到下打印二叉树Ⅱ {

    public static void main(String[] args) {
        TreeNode head=new TreeNode(3);
        head.left=new TreeNode(9);
        head.right=new TreeNode(20);
        TreeNode right=head.right;
        right.left=new TreeNode(15);
        right.right=new TreeNode(7);
        List<List<Integer>> list = levelOrder(head);
        for (List<Integer> integers : list) {
            System.out.println("integers = " + integers);
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) {
            queue.add(root);
        }
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

}
