package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * @author : 唐元晋
 * @created 2021/12/28 14:01
 */
public class _88_合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            nums1[m+i]= nums2[i];
            for (int j = m+i; j >0; j--) {
                if (nums1[j]<nums1[j-1]){
                    int tem=nums1[j];
                    nums1[j]=nums1[j-1];
                    nums1[j-1]=tem;
                }
            }
        }
    }

}
