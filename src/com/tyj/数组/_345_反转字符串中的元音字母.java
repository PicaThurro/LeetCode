package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : 唐元晋
 * @created 2022/1/4 21:15
 */
public class _345_反转字符串中的元音字母 {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }

    /**
     * 双指针从头和尾向中间移动，left right
     * 正则表达式包含大小写元音
     * 如果left指针不是元音就右移一位
     * 如果right指针不是元音就左移一位
     * 判断left和right的元素去比对正则表达式是否都为元音，是的话就交换两个位置的元素，然后左右两边的指针向中间移动一位
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        String str = "[aeiouAEIOU]";
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        String head = "";
        String tail = "";
        while (left < right) {
            head = String.valueOf(chars[left]);
            tail = String.valueOf(chars[right]);
            if (!head.matches(str)) {
                left++;
            } else if (!tail.matches(str)) {
                right--;
            } else if (head.matches(str) && tail.matches(str)) {
                char tem = chars[left];
                chars[left] = chars[right];
                chars[right] = tem;
                left++;
                right--;
            }

        }
        return String.valueOf(chars);
    }

}
