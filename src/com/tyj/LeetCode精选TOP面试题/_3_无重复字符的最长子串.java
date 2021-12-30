package com.tyj.LeetCode精选TOP面试题;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author : 唐元晋
 * @created 2021/12/30 20:05
 */
public class _3_无重复字符的最长子串 {

    public static void main(String[] args) {
        lengthOfLongestSubstring("pwwkew");
    }


    public int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        int max=0;
        int left=0;
        int right=0;
        Set<Character> set=new HashSet<>();
        while (right<chars.length){
            if (set.add(chars[right])){
                max=Math.max(max,set.size());
                right++;
            }else {
                max=Math.max(max,set.size());
                left++;
                right=left;
            }
        }

        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        //哈希集合，记录每个字符是否出现过
        Set<Character> occ=new HashSet<>();
        int n=s.length();
        //右指针，初始值为-1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk=-1,ans=0;
        for (int i = 0; i < n; ++i) {
            if (i!=0){
                //左指针向右移动一格，移除一格字符
                occ.remove(s.charAt(i-1));
            }
            while (rk+1<n&&!occ.contains(s.charAt(rk+1))){
                //不断地移动右指针
                occ.add(s.charAt(rk+1));
                ++rk;
            }
            //第i到rk个字符是一个极长的无重复字符子串
            ans=Math.max(ans,rk-i+1);
        }
        return ans;
    }

}
