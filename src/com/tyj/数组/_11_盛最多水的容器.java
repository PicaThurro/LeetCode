package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/container-with-most-water/
 * @author : 唐元晋
 * @created 2021/12/30 23:34
 */
public class _11_盛最多水的容器 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,1}));
    }

    /**
     * 双指针
     * 先计算一次left到right的容量(最短边*距离'right-left')
     * 然后最短边向中间靠近再计算一次容量
     * 每次计算的容量取最大
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=0;
        while (left<right){
            int area=Math.min(height[left],height[right])*(right-left);
            max=Math.max(max,area);
            if (height[left]<=height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }

}
