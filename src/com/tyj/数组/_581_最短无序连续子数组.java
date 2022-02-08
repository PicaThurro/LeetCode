package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 *
 * @author : 唐元晋
 * @created 2022/2/8 16:54
 */
public class _581_最短无序连续子数组 {

    /**
     * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/si-lu-qing-xi-ming-liao-kan-bu-dong-bu-cun-zai-de-/
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int len= nums.length;
        int min=nums[len-1];
        int max=nums[0];
        int begin=0,end=-1;
        for (int i = 0; i < len; i++) {
            if (nums[i]<max){
                end=i;
            }else {
                max=nums[i];
            }

            if (nums[len-i-1]>min){
                begin=len-i-1;
            }else {
                min=nums[len-i-1];
            }
        }
        return end-begin+1;
    }

}
