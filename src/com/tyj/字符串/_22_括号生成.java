package com.tyj.字符串;


import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/generate-parentheses/
 * @author : 唐元晋
 * @created 2022/1/14 19:31
 */
public class _22_括号生成 {

    /**
     * 根据官方题解
     * 只在序列仍然保持有效时才添加 '(' or ')'
     * 如果左括号数量不大于 nn，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号。
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        backtrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }

    public void backtrack(List<String> ans,StringBuilder cur,int open,int close,int max){
        if (cur.length()==max*2){
            ans.add(cur.toString());
            return;
        }
        if (open<max){
            cur.append('(');
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length()-1);
        }
        if (close<open){
            cur.append(')');
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length()-1);
        }
    }

}
