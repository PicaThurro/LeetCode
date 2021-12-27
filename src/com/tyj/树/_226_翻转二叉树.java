package com.tyj.树;

import com.tyj.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author : 唐元晋
 * @created 2021/12/21 14:52
 */
public class _226_翻转二叉树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        TreeNode node = invertTree(root);
    }

    //利用层序遍历翻转
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            TreeNode node = new TreeNode();
            if (poll.left != null && poll.right != null) {
                queue.offer(poll.left);
                queue.offer(poll.right);
                node = poll.right;
                poll.right = poll.left;
                poll.left = node;
            } else if (poll.left != null) {
                queue.offer(poll.left);
                poll.right = poll.left;
                poll.left = null;
            } else if (poll.right != null) {
                queue.offer(poll.right);
                poll.left = poll.right;
                poll.right = null;
            }

        }
        return root;
    }

    //利用前序遍历翻转(递归)
    public TreeNode invertTree2(TreeNode root) {
        if (root==null){
            return root;
        }
        TreeNode tmp=null;
        tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        invertTree2(root.left);
        invertTree2(root.right);

        return root;
    }

}
