package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @author : 唐元晋
 * @created 2022/1/17 16:25
 */
public class _33_搜索旋转排序数组 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{6, 7, 0, 1, 2, 3, 4, 5}, 0));
    }

    /**
     * 官方题解 二分查找
     * 这道题中，数组本身不是有序的，进行旋转后只保证了数组的局部是有序的
     * 将数组从中间分开成左右两部分的时候，一定有一部分的数组是有序的
     *      [4,5,6,7,0,1,2]从6这个位置分开以后数组变成了[4,5,6]和[7,0,1,2]两个部分
     *      其中左边[4,5,6]这个部分的数组是有序的
     * 这说明可以在常规二分查找的时候查找当前mid为分割位置分割出来的两个部分[l,mid]和[mid+1,r]哪个部分是有序的
     * 并根据有序的那个部分确定该如何改变二分查找的上下界，因为能够根据有序的那部分判断出target在不在这个部分：
     *          1.如果[1,mid-1]是有序数组，且target的大小满足[nums[l],nums[mid])左闭右开
     *              则应该将搜索范围缩小至[1,mid-1]，否则在[mid+1,r]中寻找
     *          2.如果[mid,r]是有序数组，且target的大小满足(nums[mid+1],nums[r]]左开右闭
     *              则应该将搜索范围缩小至[mid+1,r]，否则在[1,mid-1]中寻找
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l=0,r=n-1;
        while (l<=r){
            int mid=((r-l)>>1)+l;
            if (nums[mid]==target){
                return mid;
            }
            if (nums[0]<=nums[mid]){
                if (nums[0]<=target&&target<nums[mid]){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }else {
                if (target>nums[mid]&&target<=nums[n-1]){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }

        }
        return -1;
    }


}
