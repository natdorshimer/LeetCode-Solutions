/**
 * Author: Natalie Dorshimer
 * Date: 1-19-2020
 * Leetcode Problem 15: Three Sum
 *
 * Find all solutions of nums[x] + nums[y] + nums[z] == 0 where i!=j!=k?
 *
 * If you sort the array and iterate throughout it, you can take that value, subtract it from the sum, and it becomes a two sum problem:
 * nums[i] + nums[y] + nums[z] == 0 or   nums[y]+nums[z] == -nums[i]
 *
 * So you iterate throughout the array at value i and try and solve the two sum for x and y such that nums[x]+nums[y] == -nums[i]
 *
 * The two sum problem can be solved in O(n) using forward and backwards pointers so long as it's a sorted array.
 * If nums[low] + nums[high] < target, then you increase low by one. If nums[low] + nums[high] > target, then you decrease high by one.
 * If nums[low] + nums[high] == target, then you've found the solution that x = i, y = low, and z = high
 *
 * This can be improved, but only in the sense to remove sorting. It will still be O(n^2) regardless.
 *
 * Time Complexity: O(n^2), about as good as you can get
 *
*/

package src.Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LeetCode_15 {

    public static  List<List<Integer>> threeSum(int[] nums, int target){

        //I stick the answers into a hashset so that it every solution is unique
        HashSet<List<Integer>> ans_set = new HashSet<>();
        Arrays.sort(nums);

        for(int i = 0; i < (nums.length-2); i++) {
            int low = i+1;
            int high = nums.length-1;
            int sum = target-nums[i];

            while(low < high) {
                if(nums[low] + nums[high] == sum){
                    List ans = Arrays.asList(nums[i], nums[low], nums[high]); //This is naturally sorted because i <= low <= high
                    ans_set.add(ans);
                }

                if(nums[low] + nums[high] < sum)
                    low++;
                else
                    high--;

                //low is always higher than i, but high can cross over
                if(high == i) high--;
            }
        }


        List<List<Integer>> ans = new ArrayList<>();
        ans.addAll(ans_set); //Transforms the hashset into the proper data structure type
        return ans;
    }
}