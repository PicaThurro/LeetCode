package com.tyj.数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/majority-element/
 * @author : 唐元晋
 * @created 2022/1/22 15:35
 */
public class _169_多数元素 {

    /**
     * 因为题目说多数元素在数组中出现次数大于[n/2]的元素
     * 那么经过排序后n/2这个下标位置的元素一定是多数元素
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length>>1];
    }

}
