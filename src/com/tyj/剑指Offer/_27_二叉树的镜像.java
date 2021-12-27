package com.tyj.剑指Offer;

import com.tyj.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * @author : 唐元晋
 * @created 2021/12/27 22:04
 */
public class _27_二叉树的镜像 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root==null){
            return root;
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            TreeNode tep=poll.left;
            poll.left=poll.right;
            poll.right=tep;

            if (poll.left!=null){
                queue.offer(poll.left);
            }

            if (poll.right!=null){
                queue.offer(poll.right);
            }
        }
        return root;
    }

}
