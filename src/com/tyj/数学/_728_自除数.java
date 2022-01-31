package com.tyj.数学;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/self-dividing-numbers/
 * @author : 唐元晋
 * @created 2022/1/29 17:03
 */
public class _728_自除数 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list=new ArrayList<>();
        while (left<=right){
            if (check(left)){
                list.add(left);
            }
            left++;
        }
        return list;
    }

    public boolean check(int num){
        StringBuilder sb=new StringBuilder(String.valueOf(num));
        for (int i = 0; i < sb.length(); i++) {
            try {
                if (num%(sb.charAt(i)-'0')!=0){
                    return false;
                }
            }catch (ArithmeticException e){
                return false;
            }
        }
        return true;
    }

}
