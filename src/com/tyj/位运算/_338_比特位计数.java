package com.tyj.位运算;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/counting-bits/
 *
 * @author : 唐元晋
 * @created 2022/1/22 16:31
 */
public class _338_比特位计数 {

    /**
     * 官方题解 Brian Kernighan算法
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0){
            x&=(x-1);
            ones++;
        }
        return ones;
    }

}
