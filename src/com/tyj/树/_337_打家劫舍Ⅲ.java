package com.tyj.树;

import com.tyj.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/house-robber-iii/
 *
 * @author : 唐元晋
 * @created 2022/2/7 16:42
 */
public class _337_打家劫舍Ⅲ {

    /**
     * 动态规划
     * dp[0] 不抢劫当前节点的最大值
     * dp[1] 抢劫当前节点的最大值
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] dp=dp(root);
        return Math.max(dp[0],dp[1]);
    }

    private int[] dp(TreeNode root) {
        if (root==null){
            return new int[]{0,0};
        }
        int[] left=dp(root.left);
        int[] right=dp(root.right);
        //抢劫此节点的情况下，就不能抢劫左右子节点
        int rob=root.val+left[0]+right[0];
        //不抢劫此节点，也可以不抢劫它的左右子节点，互不影响
        //所以判断在不抢劫此节点的情况下，它的左右子节点如果不抢劫或者抢劫的最大值
        int notRob=Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        return new int[]{notRob,rob};
    }


    Map<TreeNode, Integer> f = new HashMap<>();
    Map<TreeNode, Integer> g = new HashMap<>();

    public int rob2(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }

}
