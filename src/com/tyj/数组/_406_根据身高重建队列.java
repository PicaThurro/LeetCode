package com.tyj.数组;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * @author : 唐元晋
 * @created 2022/2/9 17:40
 */
public class _406_根据身高重建队列 {

    /**
     * people[h,k]
     * 先按照h降序排序，如果h相同就按照k的升序排序
     * 然后遍历数组，用people[h][k]的k作为下标插入到list中
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o2[0]==o1[0]?o1[1]-o2[1] :o2[0]-o1[0] );
        List<int[]> list=new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1],people[i]);
        }
        return list.toArray(new int[list.size()][2]);
    }

}
