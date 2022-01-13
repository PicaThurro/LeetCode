package com.tyj.字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @author : 唐元晋
 * @created 2022/1/13 21:12
 */
public class _17_电话号码的字母组合 {


    /**
     * 回溯
     * 根据大佬的题解 https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/tong-su-yi-dong-dong-hua-yan-shi-17-dian-hua-hao-m/
     */
    String[] letter_map={" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res=new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        if (digits.length()==0){
            return res;
        }
        backtracking(digits,new StringBuilder(),0);
        return res;
    }

    public void backtracking(String digits,StringBuilder letter,int index){
        if (index==digits.length()){
            res.add(letter.toString());
            return;
        }
        char c = digits.charAt(index);
        int pos=c-'0';
        String mapString =letter_map[pos];
        for (int i = 0; i < mapString.length(); i++) {
            letter.append(mapString.charAt(i));
            backtracking(digits,letter,index+1);
            letter.deleteCharAt(letter.length()-1);
        }

    }

}
