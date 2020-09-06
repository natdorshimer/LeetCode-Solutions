
/**
 *
    Author: Natalie Dorshimer
    Date: 1-19-2020

    Leetcode Problem 16: Three Sum Closest

    Which sum nums[i] + nums[j] + nums[k] where i!=j!=k have the closest value to the target value?

    This problem can be done in pretty much the same way as 3 sum. If you start with one value and
    subtract it from the target value, you end up with a two sum problem.

    The two sum problem can be comleted in O(n) as long as the array is sorted. It uses pointers
    at the beginning and at the end and compares the sum to the target value. If num[low] + num[high] < target,
    you increase low to get a higher value. If num[low] + num[high] > target, you decrease high by 1.
    If they're equal, nums[i] + nums[low] + nums[high] == target and you can return the answer

    Otherwise you just keep track of the closest value to the target value and keep iterating i until
    you either find an exact match or find the closest. If it doesn't hit the target, this completes in


    Time Complexity: O(n^2), about as good as you can get
 *
*/

package src.Solutions;

import java.util.Arrays;


public class LeetCode_16 {

    //Requirements: nums.length >= 3;
    public static int threeSumClosest(int[] nums, int target) {
        
        if(nums.length < 3)
            throw new IllegalArgumentException("The length of nums must be greater than or equal to 3.");
    
        Arrays.sort(nums); //Two sum algorithm requires a sorted array
        int closestSum = nums[0]+nums[1]+nums[2]; //smallest array is of size 3, this gives it a guaranteed initialize

        for(int i = 0; i < (nums.length-2); i++) {
            int low = i+1;
            int high = nums.length-1;
            int sum = target-nums[i];

            while(low < high) {
                if(nums[low] + nums[high] == sum){
                    return target;
                }

                closestSum = closest(closestSum, nums[i]+nums[low]+nums[high], target);
                if(nums[low] + nums[high] < sum)
                    low++;
                else
                    high--;

                //low is always higher than i, but high can cross over
                if(high == i) high--;
            }
        }

        return closestSum;
    }

    //If num1 is closer than num2 to the target, then it returns num1 or vice versa.
    public static int closest(int num1, int num2, int target){
        return Math.abs(target-num1) < Math.abs(target-num1) ? num1 : num2;
    }
}
