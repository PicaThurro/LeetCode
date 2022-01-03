package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author : 唐元晋
 * @created 2021/12/28 14:01
 */
public class _88_合并两个有序数组 {

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            nums1[m + i] = nums2[i];
            for (int j = m + i; j > 0; j--) {
                if (nums1[j] < nums1[j - 1]) {
                    int tem = nums1[j];
                    nums1[j] = nums1[j - 1];
                    nums1[j - 1] = tem;
                }
            }
        }
    }

    /**
     * 官方题解:方法三
     * 利用好两个都是有序数组的条件
     * 初始化三个指针
     *          1.p1指向nums1的真实长度
     *          2.i指向nums1的尾部
     *          3.p2指向nums2的尾部
     * 首先判断p1是否为负数，如果p1是负数的话，就意味着nums1只需要合并进来一个元素；p2左移后小于0，结束循环。
     * 每次拿出p2位置的元素比较p1位置的元素
     *          1.如果大于等于p1位置的元素就放到i位置，然后i和p2指针左移
     *          2.如果小于p1位置的元素就把p1和i的元素交换位置，然后p1和i指针左移再重复步骤1
     * 循环条件：当p2小于0的时候结束（也就是nums2里不再有元素可以插入的情况）
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int i = nums1.length - 1;
        int p2 = nums2.length - 1;
        int tem = 0;
        while (p2 >= 0) {
            if (p1 < 0) {
                nums1[i] = nums2[p2];
                i--;
                p2--;
            } else if (nums2[p2] >= nums1[p1]) {
                nums1[i] = nums2[p2];
                i--;
                p2--;
            } else {
                tem = nums1[i];
                nums1[i] = nums1[p1];
                nums1[p1] = tem;
                p1--;
                i--;
            }
        }
    }

}
