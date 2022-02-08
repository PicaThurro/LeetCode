package com.tyj.数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * @author : 唐元晋
 * @created 2022/2/8 17:51
 */
public class _350_两个数组的交集Ⅱ {

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/liang-ge-shu-zu-de-jiao-ji-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length> nums2.length){
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1 );
        }

        int[] intersection=new int[nums1.length];
        int index=0;
        for (int num : nums2) {
            int count=map.getOrDefault(num,0);
            if (count>0){
                intersection[index++]=num;
                count--;
                if (count>0){
                    map.put(num,count);
                }else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection,0,index);
    }

}
