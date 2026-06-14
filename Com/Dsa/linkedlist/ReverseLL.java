package Com.sangram.DSA.Com.Dsa.linkedlist;

/*
 * ================================================================
 * 🧠 PROBLEM: Reversing the LinkedList
 * ================================================================
 *
 * Author : Sangram Chavanpatil
 * Date   : 2026-06-13
 *
 * ------------------------------------------------
 * 📌 Problem Statement:
 * You are given a linked lists head you have to reverse the linked list
 *
 * ------------------------------------------------
 * 💡 Approach:
 *Reversing a DLL means every node's prev and next get swapped, and then head and tail are swapped too.
 * Before:->
 * head → [10] ⇄ [20] ⇄ [30] ⇄ [40] ← tail
 * After:->
 * head → [40] ⇄ [30] ⇄ [20] ⇄ [10] ← tail
 *
 * ------------------------------------------------
 * ⏱ Time Complexity  :
 * 🗂 Space Complexity :
 *
 * ------------------------------------------------
 * 📝 Notes:
 *
 * ================================================================
 */

public class ReverseLL {


    public LLNOde reverse(LLNOde head)
    {
        LLNOde curr = head;
        LLNOde temp = null;
        while (curr!=null)
        {
            temp=curr.prev;
            curr.prev=curr.next;
            curr.next=temp;
            curr=curr.prev;     // move forward (prev now holds the old next)
        }

        // After loop: temp = last node's old prev = second last node
        // temp.prev = the old last node (which is new head)
        if(temp!=null)
        {
            head = temp.prev;
        }
        return head;

    }
    public void display(LLNOde head)
    {
        LLNOde curr=head;
        while (curr!=null)
        {
            System.out.print(curr.val+"<-->");
            curr=curr.next;


        }
        System.out.println("null");
    }



    public static void main(String[] args) {
        ReverseLL rev = new ReverseLL();
        LLNOde first = new LLNOde(10);
        LLNOde second = new LLNOde(20);
        LLNOde third = new LLNOde(30);
        LLNOde fourth = new LLNOde(40);
        first.next=second;
        first.prev=null;
        second.next=third;
        second.prev=first;
        third.next=fourth;
        third.prev=second;
        fourth.prev=third;
        fourth.next=null;

        System.out.println("before reversing ");
        rev.display(first);

        System.out.println("after reversing ");
        rev.display(rev.reverse(first));


    }
}
