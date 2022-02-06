package com.tyj.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/remove-invalid-parentheses/
 *
 * @author : 唐元晋
 * @created 2022/2/6 15:17
 */
public class _301_删除无效的括号 {

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/remove-invalid-parentheses/solution/shan-chu-wu-xiao-de-gua-hao-by-leetcode-9w8au/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int lremove = 0;
        int rremove = 0;

        //先遍历一次获取左括号和右括号数量，rremove>0代表有多余的右括号，lremove<0代表有多余的左括号
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                lremove++;
            }else if (s.charAt(i)==')'){
                if (lremove==0){
                    rremove++;
                }else {
                    lremove--;
                }
            }
        }
        helper(s,0,lremove,rremove);

        return res;

    }

    /*
     * 回溯函数
     * */
    private void helper(String str, int start, int lremove, int rremove) {
        //当左右括号数量相同的情况下，还需要判断括号是否有效
        if (lremove == 0 && rremove == 0) {
            if (isValid(str)) {
                //有效添加到ist
                res.add(str);
            }
            //不管有效与否，都要返回
            return;
        }
        for (int i = start; i < str.length(); i++) {
            //连续相同的括号只需要搜索一次
            if (i != start && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }
            //剩余的字符无法满足去掉的数量要求，直接返回
            if (lremove + rremove > str.length() - i) {
                return;
            }
            if (lremove > 0 && str.charAt(i) == '(') {
                //字符串的截取左闭右开，正好没有截取到当前下标i位置的字符,lremove-1代表去掉了一个左括号
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove - 1, rremove);

            }
            if (rremove > 0 && str.charAt(i) == ')') {
                //右括号的逻辑与上面同理
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove, rremove - 1);
            }
        }

    }

    /*
    * 辅助函数
    * 验证括号是否有效
    * */
    private boolean isValid(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else if (str.charAt(i) == ')') {
                cnt--;
                //此时如果cnt小于0，代表有多余的右括号，直接返回false
                if (cnt < 0) {
                    return false;
                }
            }
        }
        //左右括号均有效等于0，返回true，如果大于0代表有多余的左括号，返回false
        return cnt == 0;
    }

}
