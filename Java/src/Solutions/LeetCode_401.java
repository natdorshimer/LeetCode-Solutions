package src.Solutions; /**
 * @author : Natalie Dorshimer
 * @since : 1/19/20
 *
 *
 * LeetCode Problem 401: Binary Watch
 *
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
     * Each LED represents a zero or one, with the least significant bit on the right.
     * For example, the above binary watch reads "3:25".
     * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
     *
 *
 * My solution uses backtracking. I iterate through all possible times "0-11:0-59" and see if the number of LEDs
 * required by the hour plus the LEDs required by the minutes is equal to the number given
 *
 * To calculate the number of LEDs required you just convert the number to binary and count the ones
 *
**/

import java.util.LinkedList;
import java.util.List;

public class LeetCode_401 {
    
    public static List<String> readBinaryWatch(int num) {

        List<String> ans = new LinkedList();
        for(int hour = 0; hour < 12; hour++) {
            if(hour == 12)
                hour = 12;
            for(int min = 0; min < 60; min++) {
                if(validTime(hour,min,num)) {
                    ans.add(outputTime(hour, min));
                }
            }
        }

        return ans;
    }

    //Produces a string that tells the time given the hour and minute
    public static String outputTime(int hour, int min){
        String s = Integer.toString(hour) + ":";
        if(min < 10)
            s += "0";
        s += min;
        return s;
    }

    //num is the number of LEDs on
    //We can figure this out by adding number of LEDs required by the hour and the minute and seeing if it equals num
    public static boolean validTime(int hour, int min, int num) {
        return numOnes(hour) + numOnes(min) == num;
    }

    //This returns the number of 1s (or on-LEDs) required to create the number num
    //I convert the integer to a binary string and then use a regex split to get rid of all the zeroes
    public static int numOnes(int num){
        String bin_num = Integer.toBinaryString(num);
        int count = 0;
        for(int i = 0; i < bin_num.length(); i++)
            if(bin_num.charAt(i) == '1')
                count++;
        return count;
    }
}