package com.tyj.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/merge-intervals/
 * @author : 唐元晋
 * @created 2022/1/19 11:52
 */
public class _56_合并区间 {

    /**
     * 官方题解
     * 如果按照区间的左端点排序，那么在排完序的列表中，可以合并的区间一定是连续的
     * 用数组merged存储最终的答案
     * 首先，将列表中的区间按照左端点升序排序。然后将第一个区间加入merged数组中，并按顺序一次考虑之后的每个区间：
     *          1.如果当前区间的左端点在数组merged中最后一个区间的右端点之后(当前区间的头比上一个加入merged的区间的尾部大)，那么它们不会重复，可以直接将这个区间加入数组merged的末尾
     *          2.否则，它们重合，我们需要用当前区间的右端点更新数组merged中最后一个区间的右端点，将其置为二者的较大值。
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length==0){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]>merged=new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L=intervals[i][0],R=intervals[i][1];
            if (merged.size()==0||merged.get(merged.size()-1)[1]<L){
                merged.add(new int[]{L,R});
            }else {
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

}
