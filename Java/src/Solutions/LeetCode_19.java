/**
 * @author : Natalie Dorshimer
 * @since : 1/19/20
 *
 *
 * LeetCode Problem 19: Remove Nth Node From End of List
 * You have the head of a singly linked list and you want to remove the node n-th away from the end (n = 1 means removing the tail)
 * 
 * Since it's a linked list, you need to go to the end of the list to find the size. Along the way, you can fill up a dynamic array
 * List<ListNodes> with each of the nodes for later. When you've reached the end, the node you want to remove is at the size()-n position!
 * 
**/

package src.Solutions;

import src.structures.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_19 {

    //O(n), a non-null head input is required.
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        //This fills node_arr with all of the nodes
        List<ListNode> node_arr = new ArrayList<>();
        ListNode iter = head;
        int i = 0;

        while(iter.next != null) {
            node_arr.add(iter);
            iter = iter.next;
            i++;
        }

        //This adds the tail (iter.next == null)
        node_arr.add(iter);
        
        int remPos = node_arr.size()-n;
        ListNode remove = node_arr.get(remPos); 
        if(remPos > 0)
            node_arr.get(remPos-1).next = remove.next;
        else
            head = head.next;

        return head;
    }
}