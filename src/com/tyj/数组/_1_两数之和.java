package com.tyj.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author : 唐元晋
 * @created 2022/2/8 17:23
 */
public class _1_两数之和 {

    /**
     * 利用哈希表，数字为key，下标为value
     * 遍历的时候先查看target减去当前nums[i]是否存在
     *      如果存在的话就新建数组返回这个数字的value(它的下标)和当前的i(当前数字的下标)
     * 每次循环都将当前的数字put进数组
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i );
        }
        return new int[0];
    }

}
