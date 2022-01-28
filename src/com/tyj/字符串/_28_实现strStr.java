package com.tyj.字符串;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/implement-strstr/
 * @author : 唐元晋
 * @created 2022/1/28 14:57
 */
public class _28_实现strStr {

    public int strStr(String haystack, String needle) {
        if (needle.length()==0){
            return 0;
        }
        char[] chars = haystack.toCharArray();
        char[] chars1 = needle.toCharArray();
        int i=0;
        for (char aChar : chars) {
            if (aChar==chars1[0]){
                if (str(chars,i,chars1)){
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    private boolean str(char[] haystack, int index, char[] needle) {
        int nindex=0;
        while (nindex< needle.length){
            if (index>=haystack.length){
                return false;
            }
            if (haystack[index]!=needle[nindex]){
                return false;
            }
            nindex++;
            index++;
        }
        return true;
    }

}
