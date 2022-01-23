package com.tyj.数组;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * @author : 唐元晋
 * @created 2022/1/23 16:08
 */
public class _560_和为k的子数组 {


    public int subarraySum(int[] nums, int k) {
        int count=0,pre=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre+=nums[i];
            if (mp.containsKey(pre-k)){
                count+=mp.get(pre-k);
            }
            mp.put(pre,mp.getOrDefault(pre,0)+1);
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                if (sum==k){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

}
