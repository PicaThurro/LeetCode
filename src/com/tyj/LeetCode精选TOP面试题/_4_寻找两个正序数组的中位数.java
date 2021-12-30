package com.tyj.LeetCode精选TOP面试题;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @author : 唐元晋
 * @created 2021/12/30 22:02
 */
public class _4_寻找两个正序数组的中位数 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays2(new int[]{1,2},new int[]{-1,3}));
    }

    //自己写的笨比方法
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int[] rev=new int[nums1.length+nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            rev[i]=nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            rev[nums1.length+i]=nums2[i];
        }
        for (int i = 0; i < rev.length; i++) {
            for (int j = 0; j+1 < rev.length; j++) {
                if (rev[j]>rev[j+1]){
                    int tem=rev[j];
                    rev[j]=rev[j+1];
                    rev[j+1]=tem;
                }
            }
        }

        if (rev.length%2==0){
            int mid= rev.length/2;
            return (double) (rev[mid]+ rev[mid-1])/2;
        }

        return rev[rev.length/2];
    }

}
