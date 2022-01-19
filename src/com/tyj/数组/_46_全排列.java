package com.tyj.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/permutations/
 * @author : 唐元晋
 * @created 2022/1/18 15:56
 */
public class _46_全排列 {

    /**
     * 回溯
     * 出口条件：当list的size等于length的长度时,也就是已经完成排列
     *              将传入的list作为构造，新建一个list添加到resultList
     *              返回
     * 在递归的循环中，添加元素前先检查当前元素在list中是否已经存在，避免重复添加
     * 在下一次递归返回到当前递归中，删除list中的最后一个元素，再进入下一次循环
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList=new ArrayList<>();
        combination(nums,new ArrayList<>(),resultList, nums.length);
        return resultList;
    }

    public void combination (int[] nums,List<Integer> list,List<List<Integer>> resultList,int length){
        if (list.size()== length){
            resultList.add(new ArrayList<>(list));
            return;
        }
        for (int i =0 ; i < nums.length; i++) {
            if (list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            combination(nums, list, resultList,length);
            list.remove(list.size()-1);
        }
    }

}
