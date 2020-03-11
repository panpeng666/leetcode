package test;

import java.util.LinkedList;

/**
 * LinkedList底层原理练习
 * @param <E>
 */
public class ppLinkedList<E> {
    private Node first;
    private Node last;
    private int size;

    public void add(E element) {
        Node node = new Node(element);
        //{a b c d}
        if (first == null) {
            first = node;
            last = node;
        } else {
            node.previous = last;
            node.next = null;
            last.next = node;
            last = node;
        }
        size++;
    }

    private void check(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引不合规" + index);
        }
    }

    public void remove(int index) {
        Node temp = getNode(index);
        if (temp != null) {
            Node up = temp.previous;
            Node down = temp.next;
            if (up != null) {
                up.next = down;
            }
            if (down != null) {
                down.previous = up;
            }
            if (index == 0) {
                first = down;
            }
            if (index == size - 1) {
                last = up;
            }
        }
        size--;
    }




    private Node getNode(int index){
        check(index);
        Node temp=null;
        if (index<size>>1){
            temp=first;
            for (int i=0;i<index;i++){
                temp=temp.next;
            }
        }else{
            temp=last;
            for (int i=size-1;i>index;i--){
                temp=temp.previous;
            }
        }
        return temp;
    }

    public E get(int index){
        Node temp = getNode(index);
        return (E)temp.element;
    }

    public void set(int index,E element){
        Node Element = new Node(element);
        Node temp = getNode(index);
        if (index==0){
            Element.previous=null;
            Element.next=first;
            temp.previous=Element;
        }
         else if(index==size-1){
            Element.next=null;
            Element.previous=last;
            temp.next=Element;
        }
        else if (temp!=null) {
            Node up = temp.previous;
            Element.previous = up;
            Element.next = temp;
            temp.previous = Element;
            up.next = Element;
        }
        size++;

    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        Node temp = first;
        while (temp!=null){
            res.append(temp.element.toString()+',');
            temp=temp.next;
        }
        res.setCharAt(res.length()-1,']');
        return res.toString();
    }


    public static void main(String[] args) {
        ppLinkedList pp = new ppLinkedList();
        pp.add("a");
        pp.add("b");
        pp.add("c");
        pp.add("d");
        pp.add("e");

//        for (int i=0;i<100;i++){
//            pp.add(i);
//        }
        System.out.println(pp);
//        System.out.println(pp.get(0));
        pp.set(0,"666");
//        pp.remove(3);
        System.out.println(pp);
    }
}
