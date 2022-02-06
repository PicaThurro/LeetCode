package com.tyj.设计;

import com.tyj.TreeNode;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * @author : 唐元晋
 * @created 2022/2/4 16:11
 */
public class _297_二叉树的序列化与反序列化 {

    public String serialize(TreeNode root) {
        return rserialize(root,"");
    }

    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList=new LinkedList<>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    public String rserialize(TreeNode root,String str){
        if (root==null){
            str+="None,";
        }else {
            str+= root.val +",";
            str=rserialize(root.left,str);
            str=rserialize(root.right,str);
        }
        return str;
    }

    public TreeNode rdeserialize(List<String> dataList){
        if ("None".equals(dataList.get(0))){
            dataList.remove(0);
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left=rdeserialize(dataList);
        root.right=rdeserialize(dataList);

        return root;
    }



}
