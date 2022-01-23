package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/target-sum/
 * @author : 唐元晋
 * @created 2022/1/23 15:33
 */
public class _494_目标和 {

    /**
     * 回溯
     * sum记录状态
     * result记录能计算出target的表达式的数量，也就是要返回的结果
     * 每次递归都查看一次index是否已到数组的尾部
     *          如果是的话就判断一下sum是否已经等于target，如果等于target就result+1
     *          上面的判断不管是否直接，已经到数组的尾部都需要return
     *          没到数组的尾部就继续递归
     * 每次递归都要把sum减去当前的值或者加上当前的值然后进入下一次递归，同时index也要加1
     */
    private int result=0;

    public int findTargetSumWays(int[] nums, int target) {
        toFlashBack(nums,0,0,target);
        return result;
    }

    public void toFlashBack(int[] nums,int index,int sum,int target){
        if (index== nums.length){
            if(sum==target){
                result+=1;
            }
            return;
        }
        int num = nums[index];
        toFlashBack(nums, index+1, sum-num, target);
        toFlashBack(nums, index+1, sum+num, target);

    }

}
