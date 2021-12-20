package com.tyj.剑指Offer;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * @author : 唐元晋
 * @created 2021/12/20 19:08
 */
public class _53_在排序数组中查找数字Ⅰ {

    /*public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        search(nums,8);

    }*/

    public  int search(int[] nums, int target) {
        if (nums.length==0){
            return 0;
        }
        int first=findFirst(nums,target);
        if (first==-1){
            return 0;
        }
        int last=findLast(nums,target);

        return last-first+1;
    }

    private  int findLast(int[] nums, int target) {
        int left=0;
        int right= nums.length-1;
        while (left<right){
            int mid=(right-left+1)/2+left;
            if (nums[mid]<=target){
                left=mid;
            } else {
                right=mid-1;
            }
        }
        return left;
    }

    private  int findFirst(int[] nums, int target) {
        int left=0;
        int right= nums.length-1;
        while (left<right){
            int mid=(right-left)/2+left;
            if (nums[mid]<target){
                left=mid+1;
            } else {
                right=mid;
            }
        }
        if (nums[left]==target){
            return left;
        }
        return -1;
    }

}
