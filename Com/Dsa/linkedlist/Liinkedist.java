package Com.sangram.DSA.Com.Dsa.linkedlist;

public class Liinkedist {
    Node head;

    public void addFirsts(int val)
    {
        Node newNode = new Node(val);
        newNode.next=head;
        head=newNode;
    }
public void addLast(int val)
{
    Node newNode = new Node(val);

    if(head ==null)
    {
        head = newNode;
        return;
    }
    Node current = head;
    while(current.next!=null)
    {
         current=current.next;
    }
    current.next=newNode;
}

public void addAtPosition(int val,int pos)
{
    if (pos==1)
    {
        addFirsts(val);
    }
    Node newNode = new Node(val);
    Node current = head;
    for(int i=1;i<pos-1;i++)
    {
        if (current==null)
        {
            System.out.println("Position range out of bound");
            return;
        }
        current = current.next;
    }
    newNode.next=current.next;
    current.next=newNode;
}

public void NewLLFromArray(int[] arr)
{
    for (int i=0;i<arr.length;i++)
    {
        addLast(arr[i]);
    }
}

public int lengthOfLL()
{
    int count=0;
    Node current = head;
    while(current!=null)
    {
        current=current.next;
        count++;
    }
    return count;
}

public String[] searchElement(int val)
{
    Node Current = head;
    int count=0;
    while(Current!=null)
    {
        count++;
        if (val == Current.val)
        {
            return new String[]{"true",String.valueOf(count)};

        }
        else {
            Current=Current.next;
        }
    }
    return new String[]{"false"};
}
public void display()
{
    Node current = head;
    while(current!=null)
    {
        System.out.print(current.val+"-->");
        current=current.next;
    }
    System.out.println("Null");
}
    public static void main(String[] args) {
        Liinkedist l = new Liinkedist();
        l.addLast(12);
        l.addLast(22);
        l.addLast(32);
        l.addLast(42);

        System.out.println("after the element are added to the last of the list");
        l.display();

        System.out.println("Adding at first ");
        l.addFirsts(11);
        l.addFirsts(9);
        l.display();

        System.out.println("Insertion at pos");
        l.addAtPosition(15,3);
        l.display();
        System.out.println("adding new nodes from array");
        int[] arr = {1,2,3,4};
        l.NewLLFromArray(arr);
        l.display();
        System.out.println("length of the LL "+l.lengthOfLL());
        System.out.println("Checking if the element is present in the LL and if it is present then return true or else return false ");
        String[] arr1 = l.searchElement(12);
        System.out.println("Answer:  "+arr1[0]+ "  " + "position: " +arr1[1]);

    }

}
