package com.tyj.数组;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 * @author : 唐元晋
 * @created 2022/2/2 15:04
 */
public class _238_除自身以外数组的乘积 {

    /**
     * 根据官方题解
     * i位置的前缀之积乘后缀之积就是满足题目要求的除自身意外数组的乘积
     * 先遍历一次nums，算出每个nums[i]的前缀之积，放入到answer数组中
     * 再遍历一次nums，算出每个nums[i]的后缀之积，再用后缀之积乘answer[i]就是答案，直接放入answer[i]
     * 注意：第一个位置的前缀之积和最后一个位置的后缀之积，都初始化为1
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int L=1;
        for (int i = 0; i < nums.length; i++) {
            answer[i]=L;
            L*=nums[i];
        }
        int R=1;
        for (int i = nums.length-1; i >=0 ; i--) {
            answer[i]*=R;
            R*=nums[i];
        }
        return answer;
    }

}
