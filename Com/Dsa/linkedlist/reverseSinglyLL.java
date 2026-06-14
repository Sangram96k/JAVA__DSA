package Com.sangram.DSA.Com.Dsa.linkedlist;

public class reverseSinglyLL {
//    Node head;
    public Node reverseLL(Node head)
    {
        Node current=head;
        Node prev=null;
        while (current!=null)
        {
            Node Next = current.next;
            current.next=prev;
            prev=current;
            current=Next; // move forward
        }
        return prev;
    }

    public void display(Node head)
    {
        Node current=head;
        while (current!=null)
        {
            System.out.print(current.val+"-->");
            current=current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        reverseSinglyLL list = new reverseSinglyLL();
        Node f=new Node(10);
        Node s=new Node(20);
        Node t=new Node(30);
        Node fo=new Node(40);
        Node fi=new Node(50);
        f.next=s;
        s.next=t;
        t.next=fo;
        fo.next=fi;
        fi.next=null;
        System.out.println("Before reversing ");
        list.display(f);
        System.out.println("after reversing ");
        list.display( list.reverseLL(f));


    }
}
