package com.tyj.数组;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/3sum/
 * @author : 唐元晋
 * @created 2022/1/9 17:54
 */
public class _15_三数之和 {

    /**
     * 根据大佬的题解
     * 先把数组进行排序，然后遍历数组
     * 遍历时每取出的一个数的绝对值(target)，在当前取出的数字往后的数组中进行（简化为）两数之和的查找
     * 遍历时取出的数字如果跟前一个数字一致，就跳过当前的数字，"避免重复"
     * 在进行两数之和的查找时，如果符合 |nums[i]| ==nums[left]+nums[right]，就将当前遍历的数字加入集合
     *      在进行下一轮查找之前
     *              先判断left后面的数字是否跟当前数字一致，如果是就跳过left后面重复的数字 "避免重复"
     *              然后判断right前面的数字是否跟当前数字一致，如果是就跳过right前面重复的数字 "避免重复"
     *      left++左指针右移，right--右指针左移，在这个区间进行下一轮查找
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        //元素个数小于三个，不满足三元组，直接返回
        if (nums.length<3){
            return list;
        }
        //先将数组排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            if (nums[i]>0){
                break;
            }
            int target=Math.abs(nums[i]);
            int left=i+1;
            int right= nums.length-1;
            while (left<right){
                if (nums[left]+nums[right]==target){
                    List<Integer> integerList=new ArrayList<>();
                    integerList.add(nums[i]);
                    integerList.add(nums[left]);
                    integerList.add(nums[right]);
                    list.add(integerList);
                    while (left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while (left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if (nums[left]+nums[right]>target){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return list;
    }

}
