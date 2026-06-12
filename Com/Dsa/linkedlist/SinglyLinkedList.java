package Com.sangram.DSA.Com.Dsa.linkedlist;

public class SinglyLinkedList {
    Node head;
public void addLast(int val)
{
    Node newNode = new Node(val);
// if there is no head, then the new node will be the starting point or the head

    if (head ==null)
    {
        head=newNode;
        return;
    }
    Node currentNode = head;
    //check if the current node has the address of the next node and if it has move to the next node
    // else if the current node does not have address of the next node or it is null then point that next to the new node

    while(currentNode.next!=null)
    {
//        move forward
        currentNode = currentNode.next;
    }
    currentNode.next = newNode;

}


public  void addFirst(int val) {
    Node newNode = new Node(val);
    newNode.next=head;
    head=newNode;


}

public void insertAtPosition(int val,int position)
{

    if(position == 1)
    {
        addFirst(val);
        return;
    }
    Node newNode = new Node(val);
    Node current = head;
    for (int i=1;i<position-1;i++)
    {
        if (current==null)
        {
            System.out.println("position out of range ");
            return;
        }
        current=current.next;
    }

    newNode.next = current.next;
    current.next=newNode;
}

public void deleteFirst()
{
    if (head == null) {
        System.out.println("List is empty");
        return;
    }
    head = head.next;  // just move head forward — done!
}
public void deletelast()
{
   if (head==null)
   {
       System.out.println("list is empty");
       return;
   }
   if(head.next==null)
   {
       head=null;
       return;
   }
    // stop at second-to-last node
    Node current = head;
    while (current.next.next != null) {
        current = current.next;
    }
    current.next = null;  // cut off the last node
}
public void display()
{
    Node currentnode = head;
    while(currentnode!=null)
    {
        System.out.print(currentnode.val+"-->");
        currentnode = currentnode.next;
    }
    System.out.print("null");
}
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        System.out.println("after adding last");
        list.display();
        System.out.println();
        System.out.println("after adding first");
        list.addFirst(5);
        list.addFirst(7);
        list.display();
        System.out.println("Insertion in position ");
        list.insertAtPosition(99, 3);
        list.display();
        System.out.println("---------------");
        list.deletelast();
        System.out.println();
        list.display();
    }
}
