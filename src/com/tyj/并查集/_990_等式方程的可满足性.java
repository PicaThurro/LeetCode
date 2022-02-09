package com.tyj.并查集;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 * @author : 唐元晋
 * @created 2022/2/9 15:46
 */
public class _990_等式方程的可满足性 {

    /**
     * 并查集
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations/solution/deng-shi-fang-cheng-de-ke-man-zu-xing-by-leetcode-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param equations
     * @return
     */
    public boolean equationsPossible(String[] equations) {
        int[] parent=new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i]=i;
        }
        //创建集合
        for (String equation : equations) {
            if (equation.charAt(1)=='='){
                int index1=equation.charAt(0)-'a';
                int index2=equation.charAt(3)-'a';
                union(parent,index1,index2);
            }
        }
        //如果不等式的两个变量在同一集合当中，说明发生冲突，返回false
        for (String str : equations) {
            if (str.charAt(1)=='!'){
                int index1=str.charAt(0)-'a';
                int index2=str.charAt(3)-'a';
                if (find(parent,index1)==find(parent,index2)){
                    return false;
                }
            }
        }
        return true;
    }

    /*
    * 辅助函数合并两个根节点
    * */
    private void union(int[] parent, int index1, int index2) {
        parent[find(parent,index1)]=find(parent,index2);
    }

    /*
    * 辅助函数
    * 查找并返回根节点
    * */
    private int find(int[] parent, int index) {
        while (parent[index]!=index){
            //隔代压缩
            parent[index]=parent[parent[index]];
            index=parent[index];
        }
        return index;
    }

}
