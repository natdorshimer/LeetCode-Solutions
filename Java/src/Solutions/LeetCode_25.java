package src.Solutions;

/**
 * @author : Natalie Dorshimer
 * @since : 1/25/2020, Sat
 **/

import src.structures.ListNode;

import java.util.Stack;

/**
 *  Problem 25: Preverse Nodes in k-Group
 *  Reverse the nodes of a linked list k at a time
 *  So if the list is 1->2->3->4->5
 *  For k = 2, you should return 2->1->4->3->5
 *  (So you reverse the first two, then reverse the next two
 *  For k = 1, you should return 2->
 */


public class LeetCode_25 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        /*
         * Since we want to leave out the left out Nodes at the end, it's probably better we're going to want to hold off
         * On doing the reverse until we have all the nodes we want to reverse
         * This would mean an O(n^2) because we'll store them in a array and then go back to do the swaps
         *
         * One way to check if we can perform the swaps is fill up an array of size k and wait for it to be full
         * And the base case is we run into a null element before it hits k
         * We can do a recursive call on this or we can use a double loop
         *
         * It's actually useful if we use a stack to store the elements because we can pop them off as need be
         * */
        ListNode ans = head; //This will always point towards the actual head, even when the current head moves
        ListNode iter = head;

        int count = 0; //This will help us get the proper head node
        ListNode prev = null;
        while(iter != null){
            Stack<ListNode> store_stack = new Stack<ListNode>();
            //Fills up the stack with k elements
            for(int i = 1; i <= k && iter != null; i++){
                if(i == k)
                    head = iter;
                store_stack.add(iter);

                if(i == k && count == 0)
                    ans = iter;

                iter = iter.next;
            }

            //If we've managed to fill up the stack with k elements before it hit a null
            if(store_stack.size() == k){
                ListNode rev = reverseStack(store_stack);
                if(prev != null)
                    prev.next = head;
                prev = rev;
                rev.next = iter; //We reverse the stack and then attach the current position to it
            }

            //This is the base case and we're done reversing
            else{
                return ans;
            }

            count++;
        }

        return ans;
    }

    //This returns the tail of the reversed list
    //Ex it return 1-> of 3->2->1->
    public static ListNode reverseStack(Stack<ListNode> store_stack) {
        ListNode first = store_stack.pop();
        while(store_stack.size() != 0){
            ListNode second = store_stack.pop();
            first.next = second;
            first = second;
        }
        first.next = null; //this breaks the cycle
        //This returns the tail
        return first;
    }

}