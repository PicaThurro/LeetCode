package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/remove-element/
 * @author : 唐元晋
 * @created 2021/12/16 20:21
 */
public class _27_移除元素 {

    public static void main(String[] args) {
        removeElement(new int[]{0,1,2,2,3,0,4,2},2);
    }

    public static int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                count++;
            }
        }
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-1;j++){
                if(nums[j]==val){
                    int tem=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tem;
                }
            }
        }
        return nums.length-count;
    }

}
