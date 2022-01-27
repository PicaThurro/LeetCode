package com.tyj.数组;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/house-robber/
 * @author : 唐元晋
 * @created 2022/1/27 15:33
 */
public class _198_打家劫舍 {

    /**
     *     作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode-solution/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int length= nums.length;
        if (length==1){
            return nums[0];
        }
        int[] dp=new int[length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i <length ; i++) {
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[length-1];
    }

}
