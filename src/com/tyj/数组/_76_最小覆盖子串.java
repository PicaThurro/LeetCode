package com.tyj.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/minimum-window-substring/solution/shu-ju-jie-gou-he-suan-fa-hua-dong-chuan-p6ip/
 * @author : 唐元晋
 * @created 2022/1/22 20:48
 */
public class _76_最小覆盖子串 {



    /**
     * 自己写的垃圾方法 滑动窗口
     * 先将字符串t里面的每个字符作为key，出现的次数作为value存入到HashMap:text中
     * 然后再声明一个同样的HashMap:window用来作为窗口
     * 如何判断窗口是否已经包含全部的字符串t
     *          遍历text，以text的key去取window的value（如果key不存在，那就是滑动窗口呢没有包含全部的字符串t，直接返回false）
     *          用key从window取到的value，以同样的key从text取出value
     *                      如果:key(window.value>=text.value)，那就说明已经包含了全部的字符串t
     * 在窗口不包含全部字符串t的时候，需要移动right指针添加新的字符
     * 在窗口包含全部字符串t的时候，需要先计算一次最小覆盖子串的长度minLen，(如果当前计算出来的minLen更小的话)记录这个覆盖子串的起点下标begin，然后把left指针指向的元素从window删除，再移动left指针(这个步骤需要循环进行，直到窗口无法覆盖字符串t的时候退出)
     * 最后用begin和begin+minLen截断字符串s返回即可
     * minLen初始化为int型的最大值，这样用在最后判断时，如果不存在覆盖子串，用0和0来截断返回的就是空字符串(截取字符串是左闭右开)
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> text = new HashMap<>();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < tChars.length; i++) {
            text.put(tChars[i], text.getOrDefault(tChars[i], 0) + 1);
        }
        int begin = 0;
        int minLen = Integer.MAX_VALUE;
        char[] sChars = s.toCharArray();
        int left = 0;
        int right = 0;
        while (right < sChars.length) {
            window.put(sChars[right], window.getOrDefault(sChars[right], 0) + 1);
            while (check(window, text)){
                if (right - left + 1 <= minLen) {
                    minLen = right - left + 1;
                    begin = left;
                }
                window.put(sChars[left], window.getOrDefault(sChars[left], 0) - 1);
                left++;
            }
            right++;
        }
        if (minLen==Integer.MAX_VALUE){
            minLen=0;
        }
        return s.substring(begin, begin + minLen);
    }

    public boolean check(Map<Character, Integer> window, Map<Character, Integer> text) {
        for (Character character : text.keySet()) {
            if (window.getOrDefault(character,0) < text.get(character)) {
                return false;
            }
        }
        return true;
    }

}
