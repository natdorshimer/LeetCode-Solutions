package src.Solutions;
import src.structures.ListNode;

/**
 * @author : Natalie Dorshimer
 * @since : 1/19/2020, Sun
 *
 * LeetCode Problem 24: Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 **/
public class LeetCode_24 {

    public static ListNode swapPairs(ListNode head) {
        ListNode tail = head;
        ListNode start = head;
        ListNode l = head;
        if((head == null) || head.next == null)
            return head;

        ListNode temp1 = l;
        ListNode temp2 = l.next;
        temp1.next = temp2.next;
        temp2.next = temp1;

        start = temp2;
        tail = temp1;

        int i = 0;
        while(tail != null)
            tail = swap(tail,tail.next);
        return start;
    }

    //Swaps l with the value in front of it and returns the tail node of the swap
    //Self attaches itself to the head of the swapped list to maintain linkage
    public static ListNode swap(ListNode self, ListNode l){
        if((l == null) || l.next == null)
            return l;

        ListNode temp1 = l;
        ListNode temp2 = l.next;
        temp1.next = temp2.next;
        temp2.next = temp1;

        self.next = temp2;
        return temp1;
    }

}
