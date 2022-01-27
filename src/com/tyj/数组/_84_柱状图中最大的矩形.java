package com.tyj.数组;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * @author : 唐元晋
 * @created 2022/1/25 15:42
 */
public class _84_柱状图中最大的矩形 {

    /**
     * 作者：hardcore-aryabhata
     * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/dong-hua-yan-shi-dan-diao-zhan-84zhu-zhu-03w3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int res=0;
        Stack<Integer> stack=new Stack<>();

        int[] newHeights=new int[heights.length+2];
        newHeights[0]=0;
        newHeights[newHeights.length-1]=0;
        for (int i = 1; i < heights.length+1; i++) {
            newHeights[i]=heights[i-1];
        }

        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty()&&newHeights[i]<newHeights[stack.peek()]){
                int cur=stack.pop();
                int curHeight=newHeights[cur];

                int leftIndex=stack.peek();
                int rightIndex=i;
                int curWidth=rightIndex-leftIndex-1;

                res=Math.max(res,curWidth*curHeight);
            }
            stack.push(i);
        }
        return res;
    }

}
