package test;

public class Node {
    Node previous; //定义上一个节点
    Node next; //定义下一个节点
    Object element;

    public Node(Node previous, Node next, Object element) {
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    public Node(Object element) {
        this.element = element;
    }
}
