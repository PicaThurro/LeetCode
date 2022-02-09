package com.tyj.字符串;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @author : 唐元晋
 * @created 2022/2/9 15:23
 */
public class _387_字符串中的第一个唯一字符 {

    /**
     * 先遍历一次用数组来计数
     * 然后再遍历一次发现一个字母的出现字数等于1次就返回当前的下标
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] count=new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            count[chars[i]-'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i]-'a']==1){
                return i;
            }
        }
        return -1;
    }

}
