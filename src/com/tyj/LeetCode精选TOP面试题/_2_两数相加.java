package com.tyj.LeetCode精选TOP面试题;

import com.tyj.ListNode;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author : 唐元晋
 * @created 2021/12/30 19:42
 */
public class _2_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //声明两个节点
        ListNode head=null,tail=null;
        //进位变量
        int carry=0;

        //其中一个节点不为空，循环继续
        while(l1!=null||l2!=null){
            //当前节点为空取0，不为空取val
            int n1=l1!=null?l1.val:0;
            int n2=l2!=null?l2.val:0;
            //计算当前两个节点相加的值
            int sum=n1+n2+carry;

            //如果头节点为空
            if(head==null){
                //创建头结点sum取个位数，并赋值引用给head和tail
                head=tail=new ListNode(sum%10);
            }else {
                //如果头结点不为空，sum取个位数新建节点，赋值引用给tail.next
                tail.next=new ListNode(sum%10);
                //让当前tail指向下一个
                tail=tail.next;
            }

            //l1和l2如果不为空就指向下一个
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
            //sum取进位
            carry=sum/10;
            //如果有进位，用carry给tail.next创建新节点。“这一步是防止l1和l2都为空不走循环，导致进位丢失的情况”
            if(carry>0){
                tail.next=new ListNode(carry);
            }
        }
        //返回头结点
        return head;
    }

}
