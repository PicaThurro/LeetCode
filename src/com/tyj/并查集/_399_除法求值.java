package com.tyj.并查集;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/evaluate-division/
 *
 * @author : 唐元晋
 * @created 2022/2/9 16:57
 */
public class _399_除法求值 {

    /**
     * 带权值的并查集 权值是倍数关系
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/evaluate-division/solution/399-chu-fa-qiu-zhi-nan-du-zhong-deng-286-w45d/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();

        UnionFind unionFind = new UnionFind(2 * equationsSize);
        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            //合并两个节点的根节点
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if (id1 == null || id2 == null) {
                //有一个变量在集合中不存在，按照题目要求存入-1.0
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }

        }
        return res;

    }

    private class UnionFind {
        private int[] parent;

        //指向的父节点的权值
        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        /*
        * 在合并之前会先去查找它们各自的根节点
        * 合并后两个节点需要更新对应的权值关系
        * */
        public void union(Integer x, Integer y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
        }

        /*
        * 查找时就会完成路径压缩
        * 并且对应的更新权值关系
        * */
        private int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        /*
        * 此时查找出x和y节点之后，并查集除根节点以外的节点均指向根节点
        * 只需要返回 x的权值/y的权值即可
        * */
        public double isConnected(Integer x, Integer y) {
            int rootX=find(x);
            int rootY=find(y);
            if (rootX==rootY){
                return weight[x]/weight[y];
            }else {
                return -1.0d;
            }
        }
    }

}
