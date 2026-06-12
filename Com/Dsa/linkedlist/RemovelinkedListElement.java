package Com.sangram.DSA.Com.Dsa.linkedlist;
/*
 * ================================================================
 * 🧠 PROBLEM: Remove Linked List Elements (LeetCode #203)
 * ================================================================
 *
 * Author : Sangram Chavanpatil
 * Date   : 2026-06-12
 *
 * ------------------------------------------------
 * 📌 Problem Statement:
 * Given the head of a linked list and an integer `val`, remove all
 * the nodes of the linked list that have Node.val == val, and
 * return the new head of the list.
 *
 * ------------------------------------------------
 * 💡 Approach: The Dummy Node (Sentinel Node) Pattern
 * 1. Create a `dummy` node and point its `next` to the `head`.
 * This ensures that if the actual `head` needs to be deleted,
 * we don't have to write special edge-case logic for it.
 * 2. Set a pointer `curr` to start at the `dummy` node.
 * 3. Traverse the list while `curr.next` is not null:
 * - If `curr.next.val` equals the target `val`:
 * Bypass the next node by setting `curr.next = curr.next.next`.
 * (Do NOT move `curr` forward here, to catch consecutive targets).
 * - If `curr.next.val` does not equal `val`:
 * Move `curr` forward normally (`curr = curr.next`).
 * 4. Return `dummy.next` as the true start of the modified list.
 *
 * ------------------------------------------------
 * ⏱ Time Complexity  : O(N)
 * Where N is the number of nodes in the linked list. We traverse
 * every node exactly once.
 *
 * 🗂 Space Complexity : O(1)
 * We only allocate a dummy node and a single pointer (`curr`),
 * regardless of the size of the input list.
 *
 * ------------------------------------------------
 * 📝 Notes:
 * - A common pitfall is failing on consecutive targets (e.g.,
 * list = [7, 7, 7, 7], target = 7). Not advancing the `curr`
 * pointer when a deletion occurs prevents skipping over the
 * second target.
 * - Always check `curr.next != null` as your loop condition to
 * avoid a NullPointerException when checking `curr.next.val`.
 * ================================================================
 */

import java.util.LinkedList;

public class RemovelinkedListElement {
    Node head;
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

    public void createlist(int[] arr)
    {
        for (int j : arr) {
            addLast(j);
        }
    }
    public  void removeTargetElements(int val)
    {
        // PHASE 1:
        // If the list starts with the target value (or multiple targets),
        // keep shifting the head forward until we hit a safe node or null.
        while(head!=null&&head.val==val)
        {
            head=head.next;
        }

        Node current = head;
        // PHASE 2:
        // We must check current != null (in case the list became empty in Phase 1)eg[7,7,7,7]
        // AND current.next != null (to prevent the NullPointerException)
        while (current!=null&&current.next!=null)
        {
            if(current.next.val==val)
            {
                current.next=current.next.next;
                // Do NOT advance 'current' here, so we can re-check the new next node
            }
            else {
                current=current.next;
            }
        }
    }

    public void display()
    {
        Node current = head;
        while(current!=null)
        {
            System.out.print(current.val+"-->");
            current=current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        RemovelinkedListElement list = new RemovelinkedListElement();
        int[] arr = new int[]{7,8,6,5,7,8,9,2,7};
        list.createlist(arr);
        System.out.println("list created before removing element");
        list.display();
        list.removeTargetElements(7);
        System.out.println("after removing the element ");
list.display();



    }
}
