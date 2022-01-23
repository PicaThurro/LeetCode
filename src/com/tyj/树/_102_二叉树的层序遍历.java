package com.tyj.树;

import com.tyj.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @author : 唐元晋
 * @created 2022/1/23 13:00
 */
public class _102_二叉树的层序遍历 {

    /**
     * 队列
     * 标准的层序遍历模板的基础上嵌套一个for循环
     * 进入for循环时，i的值等于当前队列的元素个数，通过i--的方式来遍历，避免了queue在元素出队时造成size()的动态变化
     * for循环内部的入队操作不会造成当前i的值发生变化，每进入一次for循环体中，当前队列的元素一定属于同一层
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if (root==null){
            return list;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> integerList=new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                integerList.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            list.add(integerList);
        }
        return list;
    }

}
