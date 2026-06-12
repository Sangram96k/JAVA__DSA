package Com.sangram.DSA.Com.Dsa.linkedlist;
/*
 * ================================================================
 * 🧠 PROBLEM: Delete Node in a Linked List (LeetCode #237)
 * ================================================================
 *
 * Author : Sangram Chavanpatil
 * Date   : 2026-06-12
 *
 * ------------------------------------------------
 * 📌 Problem Statement:
 * Write a function to delete a node in a singly-linked list. You
 * will not be given access to the head of the list, instead you
 * will be given access to the node to be deleted directly.
 * It is guaranteed that the node to be deleted is not a tail node
 * in the list.
 *
 * ------------------------------------------------
 * 💡 Approach: The "Shift and Bypass" Method
 * Since we do not have access to the `head` pointer, we cannot traverse
 * from the beginning to find the node immediately preceding our target.
 * Therefore, we cannot update the previous node's `next` pointer.
 * * Instead, we shift the problem forward:
 * 1. Copy the value of the very next node (`node.next.val`) into
 * the current node (`node.val`).
 * 2. Delete the next node by bypassing it. Update the current node's
 * `next` pointer to point to the node after the next one
 * (`node.next = node.next.next`).
 *
 * ------------------------------------------------
 * ⏱ Time Complexity  : O(1)
 * We only perform two direct operations (one assignment of a value,
 * one assignment of a pointer). There is no traversal.
 *
 * 🗂 Space Complexity : O(1)
 * We modify the list in place and do not use any additional data
 * structures or memory.
 *
 * ------------------------------------------------
 * 📝 Notes:
 * - This approach is only possible because the problem guarantees
 * that the node to be deleted is NEVER the tail node. If it were
 * the tail, `node.next` would be null, and trying to copy
 * `node.next.val` would throw a NullPointerException.
 * - This is a classic "trick" question. In a real-world scenario,
 * deleting a node without head access is generally bad practice,
 * but it tests your understanding of how pointers and memory references work.
 * ================================================================
 */
public class DeleteNodeInLL{

    public void deleteNode(Node node)
    {
//        here we do not have access to the head so we cnt traverse so what I will do is that
//        I will assign the node.val (Node that is passed and parameter its val) as the value of the adjecent node that is next node
        node.val = node.next.val;
//        Skip the next node by pointing to the one after it
        node.next = node.next.next;


    }

    public void display(Node head)
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
        DeleteNodeInLL del = new DeleteNodeInLL();

        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node fifth = new Node(60);
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=null;


        System.out.println("Before deleting node");
        del.display(first);
        del.deleteNode(third);

        System.out.println("after deleting the node");
        del.display(first);



    }

}
