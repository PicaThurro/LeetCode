package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * @author : 唐元晋
 * @created 2022/1/18 15:16
 */
public class _42_接雨水 {

    /**
     * 官方题解 双指针
     * 只要right_nax[i]>left_max[i](元素0到元素6)，积水高度将由left_max（较小的边）决定
     * left_max[i]>right_max[i](元素8到元素11)
     * 可以认为如果一端有更更高的条形块（右端），积水的高度依赖于当前方向的高度（从左到右）
     * 当发现另一侧（右侧）的条形块高度不是最高的，则开始从相反的方向遍历（从右到左）
     * 必须在遍历时维护left_max和right_max，可以使用两个指针脚踢进行，实现一次遍历即可完成
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int left=0,right= height.length-1;
        int ans=0;
        int left_max=0,right_max=0;
        while (left<right){
            //如果height[right]的条形块更高
           if (height[left]<height[right]){
               //判断height[left]的条形块是否比left_max更高
               if (height[left]>=left_max){
                   //是的话就更新left_max
                   left_max=height[left];
               }else {
                   //否则就是一处可以积水的低洼，累加ans
                   ans+=left_max-height[left];
               }
               //左指针向右继续遍历
               left++;
               //左边的条形块更高
           }else {
               //判断height[right]的条形块是否比right_max更高
               if (height[right]>=right_max){
                   //是的话就更新right_max
                   right_max=height[right];
               }else {
                   //否则就是一处可以积水的低洼
                   ans+=right_max-height[right];
               }
               //右指针向左继续遍历
               right--;
           }
        }
        return ans;
    }

}
