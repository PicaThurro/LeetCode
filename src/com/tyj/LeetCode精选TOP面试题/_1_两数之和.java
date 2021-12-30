package com.tyj.LeetCode精选TOP面试题;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/two-sum/
 * @author : 唐元晋
 * @created 2021/12/30 19:32
 */
public class _1_两数之和 {

    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    if(nums[i]+nums[j]==target){
                        System.out.print("["+i+","+j+"]");
                        int [] result={i,j};
                        return result;
                    }
                }
            }
        }
        return null;
    }

}
