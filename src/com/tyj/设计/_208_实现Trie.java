package com.tyj.设计;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * @author : 唐元晋
 * @created 2022/2/1 15:20
 */
public class _208_实现Trie {

    private _208_实现Trie[] children;
    private boolean isEnd;

    public _208_实现Trie() {
        children=new _208_实现Trie[26];
        isEnd=false;
    }

    public void insert(String word) {
        _208_实现Trie node=this;
        for (int i = 0; i < word.length(); i++) {
            char ch=word.charAt(i);
            int index=ch-'a';
            if (node.children[index]==null){
                node.children[index]=new _208_实现Trie();
            }
            node=node.children[index];
        }
        node.isEnd=true;
    }

    public boolean search(String word) {
        _208_实现Trie node=searchPrefix(word);
        return node!=null&&node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix)!=null;
    }

    public _208_实现Trie searchPrefix(String prefix){
        _208_实现Trie node=this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch=prefix.charAt(i);
            int index=ch-'a';
            if (node.children[index]==null){
                return null;
            }
            node=node.children[index];
        }
        return node;
    }

}
