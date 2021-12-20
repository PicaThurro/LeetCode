package com.tyj.剑指Offer;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @author : 唐元晋
 * @created 2021/12/20 21:01
 */
public class _11_旋转数组的最小数字 {

    public int minArray(int[] numbers) {
        int left=0;
        int right=numbers.length-1;
        while (left<right){
            int mid=(right-left)/2+left;
            if (numbers[mid]<numbers[right]){
                right=mid;
            }else if (numbers[mid]>numbers[right]){
                left=mid+1;
            }else if(numbers[mid]==numbers[right]){
                right--;
            }
        }
        return numbers[left];
    }

}
