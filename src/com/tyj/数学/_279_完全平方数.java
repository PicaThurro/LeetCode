package com.tyj.数学;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/perfect-squares/
 *
 * @author : 唐元晋
 * @created 2022/2/3 14:12
 */
public class _279_完全平方数 {

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/perfect-squares/solution/wan-quan-ping-fang-shu-by-leetcode-solut-t99c/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }

}
