package com.tyj.字符串;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * @author : 唐元晋
 * @created 2022/1/9 17:14
 */
public class _14_最长公共前缀 {

    /**
     * 官方题解 横向扫描
     * 先取出第一个字符串赋值给prefix作为默认公共前缀
     * 然后从下标1（第二个字符串）开始遍历
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String prefix=strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix=longestCommonPrefix(prefix,strs[i]);
            if (prefix.length()==0){
                break;
            }
        }
        return prefix;

    }

    /*
    * 辅助函数
    * 判断并返回两个字符串的公共前缀
    * 取两个字符串长度最小的为循环条件(一个字符串数组中的公共前缀的长度肯定等于小于数组中长度最短的字符串)
    * */
    public String longestCommonPrefix(String str1,String str2) {
        int length=Math.min(str1.length(),str2.length());
        int index=0;
        while (index<length&&str1.charAt(index)==str2.charAt(index)){
            index++;
        }
        return str1.substring(0,index);
    }

}
