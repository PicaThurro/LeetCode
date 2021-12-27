package com.tyj.树;

import com.tyj.TreeNode;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @author : 唐元晋
 * @created 2021/12/27 22:35
 */
public class _108_将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0, nums.length-1);
    }

   public TreeNode helper(int[] nums,int left,int right){
        if (left>right){
            return null;
        }

        int mid=(left+right)/2;

        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,left,mid-1);
        root.right=helper(nums,mid+1,right);
        return root;

   }


}
