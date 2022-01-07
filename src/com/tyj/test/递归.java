package com.tyj.test;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : 唐元晋
 * @created 2021/12/29 23:26
 */
public class 递归 {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add(i);
        }
        System.out.println(max(list));
    }


    public static int factorial(int i){
        if (i==1){
            return i;
        }
        return i*factorial(i-1);
    }

    public static int sum(ArrayList<Integer> list){
        if (list.isEmpty()){
            return 0;
        }
        Integer integer = list.get(0);
        list.remove(0);
        return integer+sum(list);
    }

    public static int count(ArrayList<Integer> list){
        if (list.isEmpty()){
            return 0;
        }
        list.remove(0);
        return 1+count(list);
    }

    public static int max(ArrayList<Integer> list){
        if (list.isEmpty()){
            return 0;
        }
        return  Math.max(list.remove(0),max(list));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] rev=new int[nums1.length+nums2.length];
        for (int i = 0,k=0,j=0; i < rev.length; i++) {
            if (nums1[k]<nums2[j]){
                rev[i]=nums1[k];
                k++;
            }else {
                rev[i]=nums2[j];
                j++;
            }
        }
        return rev[rev.length - 1] + 0.5;
    }

}
