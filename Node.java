package LLink;

/**
 * Created by Chenjiabing on 2017/5/3.
 */
public class Node {
    public int data;
    public Node next;
    public Node(int data)
    {
        this.data=data;
    }
    public Node(int data,Node next)
    {
        this.data=data;
        this.next=next;
    }
    public Node(Node next)
    {
        this.next=next;
    }
}
