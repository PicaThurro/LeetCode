package com.tyj.字符串;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author : 唐元晋
 * @created 2022/1/8 17:50
 */
public class _3_无重复字符的最长子串 {

    /**
     * 滑动窗口
     * 根据提示先对字符串长度做一次特殊判断
     * 声明一个不能存在重复元素的哈希表set
     * 将字符串转为数组(chars)来操作
     * 声明左边界和有边界，left=0，right=0；
     * 声明一个用来保存最长子串长度的变量max
     * 遍历字符数组
     * 循环条件：右边界严格小于数组长度
     * 每一次循环都向哈希表里添加当前right指向的元素
     *      添加成功：右边界右移一位
     *      添加失败：先用max记录一次当前哈希表的size（最长子串的长度），然后删除哈希表里对应位于左边界的元素
     *              max每次记录都需要跟自己判断一次大小，以保证取到的是最长子串的长度
     * 最后在返回max之前再跟哈希表的size判断一次，防止出现输入字符串的本身不具有重复的元素而取不到最长子串的长度
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        Set<Character> set=new HashSet<>();
        char[] chars = s.toCharArray();
        int left=0;
        int right=0;
        int max=0;
        while (right<chars.length){
            if (set.add(chars[right])){
                right++;
            }else {
                max=Math.max(max,set.size());
                set.remove(chars[left]);
                left++;
            }
        }
        max=Math.max(max,set.size());
        return max;
    }

}
