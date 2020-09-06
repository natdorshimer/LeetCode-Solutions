
/**
 * @author : Natalie Dorshimer
 * @since : 1/19/20
 *
 *
 * LeetCode Problem 21: Merge Two Sorted Linked Lists
 *
 * Start at the heads and compare the values. If l1.val > l2.val then you copy l1 and add it to the new list.
 * If they're equal, you just pick one and continue. The hard part is actually the logic behind null handling
 *
 * Time Complexity: O(n)
**/

package src.Solutions;

import src.structures.ListNode;

public class LeetCode_21 {
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //If one of them is null, the merge is just the other list by itself
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        //This initializes the head.
        ListNode head;
        if (l1.val < l2.val) {
            head = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            head = new ListNode(l2.val);
            l2 = l2.next;
        }

        //This iterates through the list. It ends immediately once one of the lists reaches the end.
        ListNode iter = head;
        while (l1 != null || l2 != null) {
            //If they both have values still
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    iter.next = new ListNode(l1.val);
                    l1 = l1.next;
                    iter = iter.next;
                } else {
                    iter.next = new ListNode(l2.val);
                    l2 = l2.next;
                    iter = iter.next;
                }
            }

            //If one of the other lists is now null we can just append it to the answer and end here
            if (l1 == null && l2 != null) {
                iter.next = l2;
                return head;
            }
            else if (l1 != null && l2 == null) {
                iter.next = l1;
                return head;
            }
        }

        return head;
        
    }
}