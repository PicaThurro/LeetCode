package com.tyj.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/combination-sum/
 * @author : 唐元晋
 * @created 2022/1/17 19:30
 */
public class _39_组合总和 {

    /**
     * 回溯
     * 递归函数:
     *      sum记录状态
     *      index作为下一次递归中循环的起点
     * 出口条件：
     *      1.当sum等于target时，将list作为构造参数，重新new一个list添加到resultList
     *              list不能直接添加，因为此时方法栈中未弹出栈的栈中变量还在引用着这个list，需要拷贝一份出来添加到resultList（也许是个优化点？暂时没想到如何优化）。
     *      2.当sum大于target时，直接返回
     * for循环当中
     *      1.取出数组第一个元素添加到list，然后递归
     *              下次递归循环中用到的index必须是以当前index作为起点(往后遍历)，不然resultList会出现重复结果（出现的重复结果只是顺序不一样）
     *              sum加上当前递归遍历到的元素
     *      2.删除list的最后一个元素，进行下一轮循环(回溯)
     * @param candidates
     * @param target
     * @return
     */
    public  List<List<Integer>> combinationSum(int[] candidates, int target) {
        //用于保存结果的list
        List<List<Integer>> resultList=new ArrayList<>();
        //开始递归
        comb(candidates, 0, candidates.length, target, new ArrayList<>(), 0,resultList);
        //返回结果
        return resultList;
    }

    public  void comb(int[] nums, int index, int length, int target, List<Integer> list, int sum,List<List<Integer>> resultList) {
        if (sum == target) {
            resultList.add(new ArrayList<>(list));
            return;
        } else if (sum > target) {
            return;
        }
        for (int i = index; i < length; i++) {
            list.add(nums[i]);
            comb(nums, i, length, target, list, sum + nums[i],resultList);
            list.remove(list.size()-1);
        }

    }


}
