package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * @author : 唐元晋
 * @created 2022/1/4 21:50
 */
public class 长度最小的子数组 {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }

    /**
     * 滑动窗口
     * 左边界left，右边界right
     * 记录子数组和的sum，和记录当前最小符合条件的子数组长度min
     * 当右边界超出数组长度就结束循环
     * 每一轮循环先用sum累加right，每次记录子数组都取最小。
     *      sum如果等于target，就记录下当前的长度（min的初始化赋值为int的上限数字，这样方便比较取小）
     *      如果小于target，right右移一位
     *      如果大于target，sum先减去当前left的元素，再减当前right的元素（因为循环一开始会累加一次所以提前减掉），然后left右移一位；记录下当前的子数组长度
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int right=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        while (right< nums.length&&left< nums.length){
            sum+=nums[right];
            if (sum==target){
                min=Math.min(min,right-left+1);
                right++;
            }else if (sum>target){
                min=Math.min(min,right-left+1);
                sum-=nums[left];
                sum-=nums[right];
                left++;
            }else {
                right++;
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }

}
