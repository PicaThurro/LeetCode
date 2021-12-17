package com.tyj.数组;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/plus-one/
 * @author : 唐元晋
 * @created 2021/12/16 21:36
 */
public class _66_加一 {

    /*
    * 时间复杂度O(n)
    * 空间复杂度O(n)
    * */
    public int[] plusOne(int[] digits) {
        int carry=1;
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i]==9){
                digits[i]=0;
                carry=1;
            }else {
                digits[i]++;
                carry=0;
                break;
            }
        }
        if (carry==1){
            int[] result=new int[digits.length+1];
            for (int i = 1; i < result.length; i++) {
                result[i]=digits[i-1];
            }
            result[0]=1;
            return result;
        }
        return digits;
    }

}
