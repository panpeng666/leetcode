package 张哥21天算法计划.第三周.Day15ULRU算法;

import java.util.HashMap;

public class LRU {
    //先创建一个Node的轮子
    class Node{
        public int key,val;
        public Node next,prev;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }

    }
//基于Node实现双链表
    class DoubleList{
        //初始化头尾节点
        private Node head,tail;
        private int size;

        public void doubleList(){
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.prev=head;
            size=0;
        }
        //链表尾部加节点
        public void addDoubleList(Node node){
            //node的前后节点与老的tail节点一致
            node.next=tail.next;
            node.prev=tail.prev;
            //然后更新新的尾节点
            tail.prev.next=node;
            tail.prev=node;
            size++;
        }
        //删除某个节点
        public void delectDoubleList(Node node){
            node.prev.next=node.next;
            node.next.prev=node.prev;
            size--;
        }

        // 删除链表中第一个节点，并返回该节点，时间 O(1)
        public Node removeFirstNode(){
            if (head.next==tail){
                return null;
            }
            Node temp = head.next;
            delectDoubleList(temp);
            return temp;
        }
        public int getSize(){
            return size;
        }
    }
    class LRUCache{
        private HashMap<Integer,Node> map ;
        private DoubleList cache;
        private int cap;

        public void LRUCache(int capacity){
            map=new HashMap<>();
            cache=new DoubleList();
            this.cap=capacity;
        }
        private void makeRecently(int key) {
            Node node = map.get(key);
            cache.delectDoubleList(node);
            cache.addDoubleList(node);
        }
        private void addRecently(int key, int val) {
            Node temp = new Node(key,val);
            cache.addDoubleList(temp);
            map.put(key,temp);
        }
        private void remove(int key){
            Node temp = map.get(key);
            cache.addDoubleList(temp);
            map.remove(key);
        }
        private void removeLeastRecently(){
            Node temp = cache.removeFirstNode();
            int key = temp.key;
            map.remove(key);
        }
        public int get(int key){
            if (!map.containsKey(key))return -1;
            makeRecently(key);
            return map.get(key).val;
        }

        public void put(int key,int val){

            if (map.containsKey(key)){
                cache.delectDoubleList(map.get(key));

            }
            if (cap==cache.size){
                removeLeastRecently();
            }
            addRecently(key,val);

        }
    }
}
