package src.structures;


//This is the classic ListNode from LeetCode augmented for testing functions and ease of use
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString(){
        String s = "";
        s += Integer.toString(val);
        if(next != null)
            s += ", " + next.toString();

        return s;
    }

    public ListNode(int nums[]){
        if(nums.length != 0) {
            val = nums[0];
            ListNode iter = this;
            for (int i = 1; i < nums.length; i++) {
                iter.next = new ListNode(nums[i]);
                iter = iter.next;
            }
        }
        else{
            throw new IllegalArgumentException("The input array needs to have a value of 1 or greater");
        }
    }

    public static String toString(ListNode l){
        String s = "[";
        s += l != null ? l.toString() : "";
        s += "]";
        return s;
    }
}