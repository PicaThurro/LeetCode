package com.tyj.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * @author : 唐元晋
 * @created 2022/1/7 17:04
 */
public class _6_Z字形变换 {

    /**
     * 官方题解
     * 先创建一个List，根据输入的行数放入对应的空StringBuilder
     * 然后创建一个用来表示行数的rows初始值0（也就是第一行），和表示是否要切换行数的goingDown（默认false）
     * 将输入的字符串转换为字符数组然后遍历
     * 根据rows取出list的StringBuilder，然后放入当前遍历到的字符
     *      判断当前是否为第一行或者是最后一行，如果是就取goingDown相反的值
     *      然后rows根据goingDown是true还是false来+1或-1，达到切换行数的目的
     * 最后新建一个StringBuilder（result），遍历list，向result拼接每一行的字符串
     * 然后.toString()返回
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (s.length()<1||numRows<=1){
            return s;
        }
        List<StringBuilder> list=new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int rows=0;
        boolean goingDown=false;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            list.get(rows).append(aChar);
            if (rows==0||rows==numRows-1){
                goingDown=!goingDown;
            }
            rows+=goingDown?1:-1;
        }
        StringBuilder result=new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            result.append(stringBuilder);
        }
        return result.toString();
    }

}
