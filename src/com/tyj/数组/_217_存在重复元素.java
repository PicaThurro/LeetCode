package com.tyj.数组;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/contains-duplicate/
 *
 * @author : 唐元晋
 * @created 2022/2/4 17:28
 */
public class _217_存在重复元素 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

}
