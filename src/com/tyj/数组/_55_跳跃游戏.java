package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/jump-game/
 * @author : 唐元晋
 * @created 2022/1/18 17:44
 */
public class _55_跳跃游戏 {

    /**
     * 官方题解 贪心
     * 对于数组中的任意一个位置y，根据题目的描述
     * 只要存在一个位置x，它本身可以到达，并且它跳跃的最大长度为x+nums[x]，这个值大于等于y
     * 既x+nums[x]>=y，那么位置y也可以到达
     * 对于每一个可以到达的位置x，它使得x+1，x+2...，x+nums[x]这些连续的位置都可以到达
     * 这样以来，一次遍历数组中的每一个位置，并实时维护 最远可以到达的位置
     * 对于当前遍历到的位置x，如果它在最远可以到达的位置的范围内，那么就可以从起点通过若干次跳跃到达该位置
     * 因此可以用x+nums[x]更新最远可以到达的位置
     * 在遍历的过程中，如果最远可以到达的位置大于等于数组中的最后一个位置，那就说明最后一个位置可以到达
     * 就可以直接返回true作为答案
     * 反之，如果在遍历结束后，最后一个位置仍然不可达，就返回false
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return true;
        }
        int rightmost = 0;
        for (int i = 0; i < len; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
