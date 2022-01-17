package com.tyj.数组;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @author : 唐元晋
 * @created 2022/1/17 17:38
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Arrays.toString(searchRange(new int[]{1, 5, 6, 7, 7, 8, 8, 8, 10, 22, 22, 40, 45}, 8)));
    }

    /**
     * 官方题解 二分查找
     * 使用二分查找方法看到的处在中间位置的元素的值nums[mid]恰好等于目标元素target的时候，还需要继续查找下去
     * @param nums
     * @param target
     * @return
     * @throws InterruptedException
     */
    public static int[] searchRange(int[] nums, int target) {
        //声明并初始化数组 为[-1,-1]
        int[] result = new int[]{-1, -1};
        if (nums.length == 0) {
            return result;
        }

        int firstIndex = findFirstIndex(nums, target);
        //如果第一次查找的结果为-1，证明数组中不包含target，直接返回之前声明好的数组
        if (firstIndex == -1) {
            return result;
        }
        //将查找结果装配进数组
        result[0] = firstIndex;
        result[1] = findLastIndex(nums, target);

        return result;
    }

    /*
     * 辅助函数 查找最后一次出现target的下标位置
     * 当mid的值正好等于target时
     *       如果左边有等于target的值，那一定不是target第一次出现的位置，应该去右边的区间继续查找
     *       left=mid  去[mid,right]之间继续查找
     * 当不满足left<right条件时退出循环，此时left指向target最后一次出现的位置
     * 此方法mid的计算操作中，在除之前又加了一次1，是为了防止:
     *              (5-4)/2+4=4  此时下标4指向的值等于target的逻辑如果走通的话 这样就没法结束循环
     *              mid赋值给left  而新的left计算出来的mid又和上一次循环的mid相同
     * */
    public static int findLastIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = ((right - left + 1) >> 1) + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /*
     * 辅助函数 查找第一次出现target的下标位置
     * 当mid的值正好等于target时
     *       如果右边有等于target的值，那一定不是target第一次出现的位置，应该去左边的区间继续查找
     *       right=mid  去[left,mid]之间继续查找
     * 当不满足left<right条件时退出循环，如果数组中包含target，此时left正好指向target第一次出现的位置
     * 判断一下如果left位置的元素不等于target，那就返回-1
     * */
    public static int findFirstIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = ((right - left) >> 1) + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

}
