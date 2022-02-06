package com.tyj.数组;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : 唐元晋
 * @created 2022/2/5 15:55
 */
public class _739_每日温度 {


    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/daily-temperatures/solution/mei-ri-wen-du-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int length= temperatures.length;
        int[] ans=new int[length];
        Deque<Integer> stack=new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature=temperatures[i];
            while (!stack.isEmpty()&&temperature>temperatures[stack.peekFirst()]){
                int prevIndex=stack.pop();
                ans[prevIndex]=i-prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 自己写的辣鸡方法，超时
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        stack.push(temperatures[0]);
        int[] ans = new int[temperatures.length];
        for (int i = 0; i+1 < temperatures.length; i++) {
            int count = 1;
            int index = i+1;
            while (!stack.isEmpty() && index < temperatures.length && stack.peek() >= temperatures[index]) {
                index++;
                count++;
            }
            if (index>=temperatures.length){
                count=0;
            }
            stack.push(temperatures[i+1]);
            ans[i] = count;
        }
        return ans;
    }

}
