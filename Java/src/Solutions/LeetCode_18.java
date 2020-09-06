/**
 * @author : Natalie Dorshimer
 * @since : 1/19/20
 *
 *
 * LeetCode Problem 18: 4Sum
 *     nums [w] + nums[x] + nums[y] + nums[z] == sum
 *
 * Well, if you take nums[w] to be a constant, you can subtract it from sum and it becomes a 3-sum problem
 * nums[x]+nums[y]+nums[z] == (sum-nums[w]).
 *
 * If you solve that, then you get a list of all the 3 sum values that all sum to sum-nums[w] (or no lists at all)
 * that means that if you add nums[w] to those lists, you get the answer!
 *
 * Example: [-2,-1,0,0,1,2] and target = 0. If you start at nums[0] = -2 and do a threeSum([-1,0,0,1,2],target-nums[0])
 * You get two lists from that: [-1,1,2] and [0,0,2]. You stick nums[0] in there and you get [-2,-1,1,2] and [-2,0,0,2]!
 *
 *
 *
 * I just borrowed 3 sum from an earlier problem
**/

package src.Solutions;

import java.util.*;
import static src.Solutions.LeetCode_15.threeSum; //O(n^2)

public class LeetCode_18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        HashSet<List<Integer>> ans_set = new HashSet<>();
        Arrays.sort(nums);

        //threeSum == target-nums[i]! So subtract nums[i] from target to find the threeSum that'll give it the answer
        for (int i = 0; i < nums.length - 3; i++) {
            List<List<Integer>> threeSums = threeSum(remElement(nums, i), target - nums[i]); //O(n^2) right here btw

            //All of the answers are now in threeSums, now we tack on nums[i] to it (and keep it sorted)
            for (List<Integer> s : threeSums) {
                List<Integer> ans_list = new ArrayList();
                ans_list.addAll(s);
                ans_list.add(nums[i]);
                Collections.sort(ans_list);
                ans_set.add(ans_list);
            }
        }

        List<List<Integer>> ans = new LinkedList<>();
        ans.addAll(ans_set);
        return ans;
    }

    //This removes nums[i] so that the resultant array can be input to calculate the threeSum 
    public static int[] remElement(int[] nums, int pos) {
        int[] new_arr = new int[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < pos)
                new_arr[i] = nums[i];
            else if (i > pos)
                new_arr[i - 1] = nums[i];
        }
        return new_arr;
    }
}