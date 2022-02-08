package com.tyj.字符串;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/decode-string/
 *
 * @author : 唐元晋
 * @created 2022/2/8 15:24
 */
public class _394_字符串解码 {


    /**
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi=multi*10+Integer.parseInt(c+"");
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }


}
