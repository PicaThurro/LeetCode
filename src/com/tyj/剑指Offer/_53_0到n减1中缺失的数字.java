package com.tyj.剑指Offer;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 * @author : 唐元晋
 * @created 2021/12/20 20:21
 */
public class _53_0到n减1中缺失的数字 {

    public int missingNumber(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=(right-left)/2+left;
            if (nums[mid]==mid){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return left;
    }

}
