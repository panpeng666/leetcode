package test;

import java.util.Stack;

public class ppLinkList {
    /**
     * Definition for singly-linked list.
     * */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


  static   public void print(ListNode listNode){
        while (listNode.next!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
      System.out.println(listNode.val);
    }


   static public ListNode reverseListNode(ListNode listNode){
       Stack<Integer> stack = new Stack<>();
       while (listNode!=null){
           stack.push(listNode.val);
           listNode=listNode.next;
       }

       ListNode res = new ListNode(stack.pop());
        ListNode other = res;
       while (!stack.isEmpty()){
           ListNode temp = new ListNode(stack.pop());
           res.next=temp;
           other=temp;
       }

       return res;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
//        listNode.val=0;
//        listNode.next=null;
  //      int i=1;
//        ListNode temp = new ListNode(i);
//        while (i<10){
//            ListNode temp = new ListNode(i);
//            temp.next=listNode;
//            listNode=temp;
//            i++;
////            System.out.println(i);
//        }
        System.out.println("==========");
        System.out.println(listNode.next);
        print(listNode);
        ListNode ans = reverseListNode(listNode);
        System.out.println("==========");
        print(ans);
    }

}
