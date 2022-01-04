package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @author : 唐元晋
 * @created 2022/1/4 18:24
 */
public class _167_两数之和Ⅱ {

    /**
     * 双指针left和right，从0和尾部开始
     * right如果大于target就一直左移
     * left加right如果大于target，right就左移
     * left加right如果小于target，left右移
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;
        while (left<right){
            if (numbers[left]+numbers[right]==target){
                return new int[]{left+1,right+1};
            }else if (numbers[right]>target||numbers[left]+numbers[right]>target){
                right--;
            }else if (numbers[left]+numbers[right]<target){
                left++;
            }
        }
        return new int[]{0,0};
    }

}
