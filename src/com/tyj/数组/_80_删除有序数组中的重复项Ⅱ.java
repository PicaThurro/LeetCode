package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * @author : 唐元晋
 * @created 2021/12/31 16:20
 */
public class _80_删除有序数组中的重复项Ⅱ {

    /**
     * 官方题解
     * 数组长度不超过2无需处理，直接返回
     * 声明快指针和慢指针都为下标1
     * 如果慢指针的上上个元素不等于快指针的元素，就把快指针放到当前慢指针的位置，然后快慢指针都往右移动一位
     * 如果不等于快指针右移，直到找到不等于慢指针的上上个元素。这样能保证可以保留重复出现一次的数据也不丢失只出现过一次的数据
     * 循环上面的操作直到快指针越界
     * @param nums
     * @return 此时慢指针指向的下标就是处理后新数组的长度
     */
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        if (len<=2){
            return len;
        }

        int slow=2;
        int fast=2;

        while (fast<len){
            if (nums[slow-2]!=nums[fast]){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }

}
