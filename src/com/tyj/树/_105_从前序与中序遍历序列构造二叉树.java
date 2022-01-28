package com.tyj.树;

import com.tyj.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author : 唐元晋
 * @created 2022/1/28 14:34
 */
public class _105_从前序与中序遍历序列构造二叉树 {

    /**
     *     作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen= preorder.length;
        int inLen= inorder.length;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i],i );
        }
        return buildTree(preorder,0,preLen-1,map,0,inLen-1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft>preRight||inLeft>inRight){
            return null;
        }
        int rootValue=preorder[preLeft];
        TreeNode root=new TreeNode(rootValue);
        int pIndex=map.get(rootValue);
        root.left=buildTree(preorder,preLeft+1,pIndex-inLeft+preLeft,map,inLeft,pIndex-1);
        root.right=buildTree(preorder,pIndex-inLeft+preLeft+1,preRight,map,pIndex+1,inRight);
        return root;
    }


}
