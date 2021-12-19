package com.tyj.栈;


import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @author : 唐元晋
 * @created 2021/12/17 14:52
 */
public class _20_有效的括号 {

    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
            } else{
                if (stack.isEmpty()){
                    return false;
                }
                Character left = stack.pop();
                if (left=='('&&aChar!=')') {
                    return false;
                }
                if (left=='{'&&aChar!='}') {
                    return false;
                }
                if (left=='['&&aChar!=']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
}
