package com.tyj.字符串;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/ransom-note/
 * @author : 唐元晋
 * @created 2022/2/9 15:28
 */
public class _383_赎金信 {

    /**
     * 用两个数组记录字母出现的次数 ransomNote=textCount magazine=patternCount
     * 当textCount中下标[i]的数字比patternCount下标[i]的数字大时，那就证明无法组成赎金信返回false
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length()<ransomNote.length()){
            return false;
        }
        char[] text = ransomNote.toCharArray();
        char[] pattern = magazine.toCharArray();
        int[] patternCount=new int[26];
        int[] textCount=new int[26];
        for (int i = 0; i < pattern.length; i++) {
            patternCount[pattern[i]-'a']++;
        }
        for (int i = 0; i < text.length; i++) {
            textCount[text[i]-'a']++;
        }
        for (int i = 0; i < textCount.length; i++) {
            if (textCount[i]>patternCount[i]){
                return false;
            }
        }
        return true;

    }

}
