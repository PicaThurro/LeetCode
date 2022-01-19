package com.tyj.字符串;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/group-anagrams/
 * * @author : 唐元晋
 * @created 2022/1/18 17:18
 */
public class _49_字母异位词分组 {

    /**
     * 官方题解
     * 由于字母异位词的两个字符串包含的字母相同，因此两个字符串中的相同字母出现的次数一定是相同的
     * 故可以将每个字母出现的次数使用字符串表示，作为哈希表的键
     * 由于字符串只包含小写字母，因此对于每个字符串，可以使用长度为26的数组记录每个字母出现的次数
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            //这个key存在就取出list，往里面添加str，不存在就新建一个list
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            //Hashmap如果存入相同的key，只会将value覆盖，这样不会导致重复的结果
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }


}
