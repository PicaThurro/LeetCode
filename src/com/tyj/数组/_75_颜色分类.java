package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/sort-colors/
 * @author : 唐元晋
 * @created 2021/12/31 17:02
 */
public class _75_颜色分类 {

    //笨比冒泡排序
    public void sortColors2(int[] nums) {
        if (nums.length==0){
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1; j-1 >=0; j--) {
                if (nums[j]<nums[j-1]){
                    int tem=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=tem;
                }
            }
        }
    }

    /**
     * 设定三个区间p1,i,p2;
     * p1区间只能是0，i区间只能是1，p2区间只能是2；
     * 当i发现是0就与p1交换，发现是1向右移动一位，发现是2就与p2交换
     * @param nums
     */
    public void sortColors(int[] nums) {
        int len=nums.length;
        if (len<1){
            return;
        }
        int p1=0;
        int i=0;
        int p2=len-1;
        while (i<=p2){
            if (nums[i]==0){
                swap(nums,i,p1);
                p1++;
                i++;
            }else if (nums[i]==1) {
                i++;
            }else if (nums[i]==2){
                swap(nums,i,p2);
                p2--;
            }
        }
    }

    private void swap(int[] nums,int index1,int index2){
        int tem=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=tem;
    }

}
