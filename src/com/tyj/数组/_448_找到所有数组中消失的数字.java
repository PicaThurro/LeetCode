package com.tyj.数组;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * @author : 唐元晋
 * @created 2022/2/8 16:26
 */
public class _448_找到所有数组中消失的数字 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        for (int num : nums) {
            set.add(num);
        }
        int n= nums.length;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }

}
