package com.tyj.数组;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/burst-balloons/
 *
 * @author : 唐元晋
 * @created 2022/2/7 15:29
 */
public class _312_戳气球 {


    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/burst-balloons/solution/chuo-qi-qiu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums){
        int n= nums.length;
        int[][] rec=new int[n+2][n+2];
        int[] val=new int[n+2];
        val[0]=val[n+1]=1;
        for (int i = 1; i <=n ; i++) {
            val[i]=nums[i-1];
        }
        for (int i = n-1; i >=0 ; i--) {
            for (int j = i+2; j <=n+1 ; j++) {
                for (int k = i+1; k < j; k++) {
                    int sum=val[i]*val[k]*val[j];
                    sum+=rec[i][k]+rec[k][j];
                    rec[i][j]=Math.max(rec[i][j],sum);
                }
            }
        }
        return rec[0][n+1];
    }



    public int[][] rec;
    public int[] val;

    public int maxCoins2(int[] nums) {
        int n = nums.length;
        val = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        val[0] = val[n + 1] = 1;
        rec = new int[n + 2][n + 2];
        for (int i = 0; i <= n + 1; i++) {
            Arrays.fill(rec[i], -1);
        }
        return solve(0, n + 1);
    }

    public int solve(int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        if (rec[left][right] != -1) {
            return rec[left][right];
        }
        for (int i = left + 1; i < right; i++) {
            int sum = val[left] * val[i] * val[right];
            sum += solve(left, i) + solve(i, right);
            rec[left][right] = Math.max(rec[left][right], sum);
        }
        return rec[left][right];
    }

}
