package com.tyj.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/word-search/
 * @author : 唐元晋
 * @created 2022/1/25 14:44
 */
public class _79_单词搜索 {

    /**
     * 回溯
     * 垃圾代码，效率较差
     * 当StringBuilder的长度与word相同时将result赋值为true
     * 当result为true时直接返回，已经确定结果就不需要继续递归下去
     * 用了哈希表record来记录使用过的位置，避免查询重复位置
     */
    boolean result = false;
    Map<String,Integer> record=new HashMap<>();

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]==word.charAt(0)){
                    toFlashBack(board, i, j, 0, new StringBuilder(), word);
                }
                if (result){
                    return result;
                }
                record.clear();
            }
        }
        return result;
    }

    public void toFlashBack(char[][] board, int row, int field, int index, StringBuilder sb, String word) {
        if (result){
            return;
        }
        if (row < 0 || row >= board.length|| field < 0 || field >= board[row].length||index>=word.length()) {
            if (word.length() == sb.length()) {
                result = true;
            }
            return;
        }
        String key=row+""+field;
        if (record.get(key)!=null){
            return;
        }
        if (board[row][field] == word.charAt(index)) {
            record.put(key,0);
            sb.append(board[row][field]);
            toFlashBack(board, row + 1, field, index + 1, sb, word);
            toFlashBack(board, row - 1, field, index + 1, sb, word);
            toFlashBack(board, row, field + 1, index + 1, sb, word);
            toFlashBack(board, row, field - 1, index + 1, sb, word);
            sb.deleteCharAt(sb.length() - 1);
            record.remove(key);
        }
    }
}


