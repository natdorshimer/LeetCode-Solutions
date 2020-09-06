package src.Solutions;


import src.structures.ListNode;

/**
 * @author : Natalie Dorshimer
 * @since : 1/19/2020, Sun
 *
 * LeetCode Problem 23: Merge k Sorted Linked Lists
 *
 * This isn't necessarily a fast solution but it is a quick one using the solution mergeTwoLists from Problem 21
 * All you have to do is continuously merge the working list (iter) with the lists in the ListNode[] array
 *
 * mergeTwoLists is O(n)
 * Time Complexity: O(n^2)
 **/

public class LeetCode_23 {
    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode iter = null;
        for(int i = 0; i < lists.length; i++) {
            iter = LeetCode_21.mergeTwoLists(iter, lists[i]);
        }
        return iter;
    }
}
