package com.tyj.字符串;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/integer-to-roman/
 * @author : 唐元晋
 * @created 2022/1/8 20:50
 */
public class _12_整数转罗马数字 {

    /**
     * 官方题解
     * 对于罗马数字从左到右的每一位，选择尽可能大的符号值。对于 140140，最大可以选择的符号值为C=100。
     * 接下来，对于剩余的数字 40，最大可以选择的符号值为 XL=40。因此，140的对应的罗马数字为C+XL=CXL。
     * 根据罗马数字的唯一表示法，为了表示一个给定的整数 num，我们寻找不超过num 的最大符号值，将 num 减去该符号值，然后继续寻找不超过 num 的最大符号值
     * 将该符号拼接在上一个找到的符号之后，循环直至num 为 00。最后得到的字符串即为 num 的罗马数字表示。
     * 编程时，可以建立一个数值-符号对的列表 valueSymbols，按数值从大到小排列。遍历 valueSymbols 中的每个数值-符号对，若当前数值 value 不超过 num，则从num 中不断减去 value，直至 num 小于 value，然后遍历下一个数值-符号对。若遍历中num 为 00 则跳出循环。
     */
    int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] symbols={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value=values[i];
            String symbol=symbols[i];
            while (num>=value){
                num-=value;
                sb.append(symbol);
            }
            if (num==0){
                break;
            }
        }
        return sb.toString();
    }

}
