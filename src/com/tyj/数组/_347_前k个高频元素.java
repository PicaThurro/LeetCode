package com.tyj.数组;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @author : 唐元晋
 * @created 2022/2/7 18:09
 */
public class _347_前k个高频元素 {

    /**
     * 利用哈希表和优先队列
     * 时间复杂度O(n);
     * 空间复杂度O(n);
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //用数字作为key，出现的次数作为value存入map
            map.put(nums[i],map.getOrDefault(nums[i],0)+1 );
        }

        //声明一个优先队列(大根)，泛型数组，int[0]代表出现的次数,int[1]代表这个出现的数字
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //用出现次数来比较大小
                return o2[0]-o1[0];
            }
        });

        //然后遍历map，把value放到int[0]，把key放在int[1]然后入队
        for (Integer integer : map.keySet()) {
            queue.offer(new int[]{map.get(integer),integer});
        }

        //声明一个用来存放答案的数组
        int[] ans=new int[k];

        //再遍历这个优先队列，依次出队出现次数最大的值存入ans
        for (int i = 0; i < k; i++) {
            ans[i]=queue.poll()[1];
        }

        return ans;
    }

}
