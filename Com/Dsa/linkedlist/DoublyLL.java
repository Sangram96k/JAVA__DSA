package Com.sangram.DSA.Com.Dsa.linkedlist;

public class DoublyLL {
    LLNOde head;
    LLNOde tail;
    public void addFirst(int val)
    {
        LLNOde newNode = new LLNOde(val);
        if (head==null)
        {
            head=tail=newNode;
            return;
        }
      newNode.next=head;
        head.prev=newNode;
        head=newNode;


    }


//    Insert element at the tail od LL
    public void insertAtLast(int val)
    {
        LLNOde newNode = new LLNOde(val);
        if (tail==null)
        {
            head=tail=newNode;
            return;

        }
        tail.next=newNode;
        newNode.prev=tail;
       tail=newNode;

    }

    public void insertAtPos(int val,int pos)
    {
        if (pos<1)
        {
            System.out.println("invalid position position must be 1 or greater");
            return;
        }
if(pos==1)
{
    addFirst(val);
}

        LLNOde current = head;
        for (int i=1;i<pos-1;i++)
        {
            if (current==null)
            {
                System.out.println("current is null");
                return;
            }
            current=current.next;
        }
        // Edge Case: If current is null here, the position was too large
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        LLNOde newNode = new LLNOde(val);
        newNode.next = current.next;
        newNode.prev = current;
         // Safety Check: Are we inserting in the middle, or at the very end?
        if (current.next != null) {
            // Middle insertion: the node AFTER current exists, so update its prev
            current.next.prev = newNode;
        } else {
            // End insertion: current is the last node, so the new node becomes the tail
            tail = newNode;
        }

        // Finally, point current to the new node
        current.next = newNode;

    }
    public void llFromArray(int[] arr)
    {
        for (int j : arr) {
            insertAtLast(j);
        }
    }


    // Delete Operations
    public void deleteHead()
    {
        if (head==null)
        {
            return;
        }
        if (head==tail){head=tail=null;return;}

        head=head.next;
        head.prev=null;
    }

    public void deleteTail()
    {
     if (tail==null)
     {
         return;
     }
     if(tail==head)
     {
         head=tail=null;
     }
     tail=tail.prev;
     tail.next=null;
    }


    public int[] searchElement(int target)
    {
        int count=0;
            LLNOde curr = head;
            while (curr!=null)
            {
                count++;
                if (curr.val==target)
                {
                    return new int[]{curr.val,count};
                }
                curr=curr.next;
            }
            return null;


    }
    public void display()
    {
        LLNOde current = head;

        while(current!=null)
        {
            System.out.print(current.val+"<-->");
            current= current.next;
        }
        System.out.println("null");
    }
    public void backwardDisplay()
    {
        LLNOde curr = tail;
        while(curr!=null)
        {
            System.out.print(curr.val+"<-->");
            curr = curr.prev;
        }
        System.out.println("null");

    }

    @Override
    public String toString() {
        return "DoublyLL{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }

    public static void main(String[] args) {
        DoublyLL Dlllist = new DoublyLL();
        Dlllist.addFirst(10);
        Dlllist.addFirst(12);
        Dlllist.addFirst(14);
        Dlllist.display();

        System.out.println("adding elements to the tail or last");
        Dlllist.insertAtLast(20);
        Dlllist.insertAtLast(21);
        Dlllist.insertAtLast(22);
        Dlllist.display();
        Dlllist.insertAtPos(30,6);
        Dlllist.display();
//        Dlllist.backwardDisplay();
        int[] res = Dlllist.searchElement(12);
        System.out.println("res: "+res[0]+"at position"+res[1]);

    }
}
