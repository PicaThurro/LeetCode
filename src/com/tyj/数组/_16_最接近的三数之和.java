package com.tyj.数组;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/3sum-closest/
 * @author : 唐元晋
 * @created 2022/1/9 19:29
 */
public class _16_最接近的三数之和 {

    /**
     * 将问题拆分成两数之和
     * 先将数组排序
     * 声明一个用来存放最小的“差的绝对值”的变量min
     * "当一个数字减去target的绝对值越小，就说明这个数字离target越接近"
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        //先将数组排序
        Arrays.sort(nums);
        //声明用来存放要返回的结果
        int result=0;
        //min初始化为int类型的最大值，方便后面判断取小
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            //下面将问题拆分成了两数之和
            //左指针在i的右一位
            int left=i+1;
            //右指针在尾部
            int right= nums.length-1;
            while (left<right){
                //先计算出这三个数字的和
                int sum=nums[i]+nums[left]+nums[right];
                //判断这个和减去target的绝对值是否比min小
                if (Math.abs(sum-target)<min){
                    //将当前的和存入result
                    result=sum;
                    //将当前计算出的绝对值存入min
                    min=Math.abs(sum-target);
                }
                //上面的判断是否执行，都不影响下面的逻辑执行，下面的逻辑保证每一个数字都参与了计算
                //sum小于target就将左指针右移
                if (sum<target){
                    left++;
                    //反之就将右指针左移
                }else if (sum>target){
                    right--;
                    //如果有三数之和等于target的情况，就直接返回sum
                }else {
                    return sum;
                }
            }
        }
        return result;
    }

}
