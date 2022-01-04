package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/valid-palindrome/
 * @author : 唐元晋
 * @created 2022/1/4 20:27
 */
public class _125_验证回文串 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }

    /**
     * 先把输入字符串转换为小写
     * 声明两个指针left和right，从头和尾开始向中间移动
     * 两个指针任意一个如果不是字符和0或者是‘ ’就向中间移动一位
     * 然后判断两个指针的元素是否相等，如果不相等直接返回false
     *      如果是只输入了空字符串
     *      不会走循环，执行到最后返回true
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        System.out.println("s = " + s);
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(chars[left]) || chars[left] == ' ') {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[right]) || chars[right] == ' ') {
                right--;
                continue;
            }
            if (chars[left] != chars[right]) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

}
