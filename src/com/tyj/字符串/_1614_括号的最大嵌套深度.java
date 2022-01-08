package com.tyj.字符串;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/
 * @author : 唐元晋
 * @created 2022/1/7 23:44
 */
public class _1614_括号的最大嵌套深度 {

    /**
     *
     * @param s
     * @return
     */
    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack=new Stack<>();
        int depth=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='('){
                stack.push('(');
            }else if (chars[i]==')'){
                depth=Math.max(depth,stack.size());
                stack.pop();
            }
        }
        return depth;
    }

}
