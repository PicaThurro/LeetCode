package com.tyj.剑指Offer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : 唐元晋
 * @created 2021/12/19 22:19
 */
public class _03_数组中重复的数字 {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])){
                return nums[i];
            }
        }
        return 0;
    }

}
