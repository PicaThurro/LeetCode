package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * @author : 唐元晋
 * @created 2021/12/20 21:13
 */
public class _154_寻找旋转排序数组中的最小值Ⅱ {

    public int findMin(int[] numbers) {
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
