package com.tyj.数组;


/**
 * Created by Intelliright IDEA.
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author : 唐元晋
 * @created 2021/12/31 15:04
 */
public class _26_删除有序数组中的重复项 {

    public static void main(String[] args) {
//        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));;
    }

    /**
     * 自己写的
     * 初始化两个指针left和right，从0开始
     * right往右移动直到找到与left不相等的值，把right放在left的后一位，此时left右移，right指针保持不变
     * 循环上面的操作直到right指针越界结束
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left=0;
        int right=0;
        while (right< nums.length){
            while (right< nums.length){
                if (nums[left]!=nums[right]){
                    nums[left+1]=nums[right];
                    break;
                }
                right++;
            }
            left++;
        }
        return left;
    }

    /**
     * 官方题解
     * 利用left和right指向下标1,从下标1开始是为了防止丢失第一个值
     * right往右移动，找到与它前一位不相同的数放到left，此时left右移一位
     * 重复上面的操作直到right越界
     * @param nums
     * @return 此时left的下标正好就是删除重复项后的新长度
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left=1;
        int right=1;
        while (right< nums.length){
            if (nums[right]!=nums[right-1]){
                nums[left]=nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

}
