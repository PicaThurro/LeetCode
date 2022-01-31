package com.tyj.数组;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * @author : 唐元晋
 * @created 2022/1/31 15:27
 */
public class _128_最长连续序列 {

    /**
     *     作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/zui-chang-lian-xu-xu-lie-by-leetcode-solution/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set=new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak=0;

        for (Integer num : num_set) {
            if (!num_set.contains(num-1)){
                int currentNum=num;
                int currentStreak=1;

                while (num_set.contains(currentNum+1)){
                    currentNum+=1;
                    currentStreak+=1;
                }

                longestStreak=Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }

}
