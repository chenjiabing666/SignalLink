package LLink;

import java.util.Scanner;

/**
 * Created by Chenjiabing on 2017/5/3.
 */
public class Link {

    protected Node head;
    protected Node tail;
    public static Scanner console = new Scanner(System.in);

    public Link() {
        head = tail = new Node(null);  //初始化将其赋值为相同，并且为空
    }

    //在尾部插入节点
    public void appendNode(int data) {
        Node p = new Node(data, null);
        tail.next = p;
        tail = tail.next;   //tail节点后移到新插入的节点p,此时的p作为新的尾节点

    }


    //头插法，会将输入的顺序逆置
    public void insert_head_Node(int data) {
        Node p = new Node(data, null);
        if (head.next == null)       //如果一开头结点后面还没有节点的时候直接接在头节点的后面即可
        {
            head.next = p;
            tail = p;
        } else {
            p.next = head.next;     //首先将新插入的节点和head后面的一个节点相连，否则先和head相连，那么后面就不能向后寻找节点了
            head.next = p;   //将head和p相连
        }
    }


    //头插法逆置
    public void reverse_data() {
        Node p = head.next;  //保存头结点下一个节点
        tail = p;   //保持逆置后的tail依然是尾节点，因为逆置过后这里的第一个数据即是尾节点
        head.next = null;  //将头结点断开
        while (p != null) {
            Node p_next = p.next;
            p.next = head.next;
            head.next = p;    //这里采用头插法
            p = p_next;
        }
    }

    //查找数据，如果找到就返回true
    public boolean find(int data) {
        Node p = head.next;
        while (p != null) {
            if (data == p.data)
                return true;
            p = p.next;
        }
        return false;
    }

    //删除指定的数据data节点，但是我们还有保留尾节点，因此需要判断
    public boolean delete(int data) {
        Node p = head.next;
        Node q = head;
        while (p != null) {
            if (p.data == data && p != tail) {   //如果找到的不是尾节点
                q.next = p.next;   //将前面的节点和后面的节点相连即是删除
                return true;
            } else if (p.data == data && p == tail)   //如果找到的时尾节点就将节点前移
            {
                tail = q;   //将尾节点移到前面即可
                q.next = p.next;   //删除节点
                return true;
            }
            p = p.next;
            q = q.next;
        }
        return false;
    }

    //打印出所有的节点数据
    public void display() {
        Node p = head.next;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;   //节点后移
        }
        System.out.println("伪结点是：" + tail.data);
    }


    //从头结点开始逐个删除节点
    public void deleteFromHead() throws NullPointerException {
//        int data=0;
//        try {
//            data = head.next.data;
//        }catch (NullPointerException e)
//        {
//            e.printStackTrace();
//        }
//
//        if (head.next == null) {
//            head = tail ;
//        } else {
//            head.next = head.next.next;
//        }
//        return data;
        if (head.next!=null)
        {
            int data=head.next.data;
            head.next=head.next.next;
        }
        else if(head.next==null)    //如果只有一个头结点的话，为了保留尾节点，直接将尾节点和头结点保持一致
        {
            tail=head;
        }
}

    public static void main(String args[]) {
        Link link = new Link();
        System.out.println("请输入想要插入的数据：");
        for (int i = 0; i < 3; i++) {
            int data = console.nextInt();
            link.appendNode(data);
            //link.insert_head_Node(data);

        }
        //link.reverse_data();
        System.out.println(link.find(33));
        for(int i=0;i<4;i++)
      link.deleteFromHead();
        link.display();
    }


}
