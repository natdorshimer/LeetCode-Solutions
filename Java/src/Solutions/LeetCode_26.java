package src.Solutions;

import java.util.Arrays;

/**
 * @author : Natalie Dorshimer
 * @since : 1/25/2020, Sat
 **/
public class LeetCode_26 {

    //Return the length of the removed duplicates
    public static int removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        if(nums == null)
            return 0;
        else if(nums.length == 1)
            return 1;
        int pos = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[pos] = nums[i];
                pos++;
            }
        }

        return pos;
    }

}
