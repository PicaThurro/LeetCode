package com.tyj.数组;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * @author : 唐元晋
 * @created 2022/2/4 15:10
 */
public class _287_寻找重复数 {

    /**
     * 转换为链表是否存在环的问题
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow=0,fast=0;
        do {
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while (slow!=fast);
        slow=0;
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }

    public int findDuplicate2(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])){
                return nums[i];
            }
        }
        return -1;
    }

}
