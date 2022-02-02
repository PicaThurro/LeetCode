package com.tyj.图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/course-schedule/
 * @author : 唐元晋
 * @created 2022/2/1 14:48
 */
public class _207_课程表 {

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/course-schedule/solution/ke-cheng-biao-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    List<List<Integer>> edges;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        indeg=new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i]==0){
                queue.offer(i);
            }
        }

        int visited=0;
        while (!queue.isEmpty()){
            ++visited;
            int u=queue.poll();
            for (int v:edges.get(u)){
                --indeg[v];
                if (indeg[v]==0){
                    queue.offer(v);
                }
            }
        }
        return visited==numCourses;

    }

}
