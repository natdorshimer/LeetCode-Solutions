package src.Solutions;

/**
 * @author : Natalie Dorshimer
 * @since : 1/25/2020, Sat
 *
 * Problem 32: Longest Valid Parentheses
 *
 * This is a VERY interesting problem. It can be done in about O(n) time!
 * A valid substring has to end on ')'. You can keep an array that keeps track of the longest substring at that point
 * So if the string is '(())' dp = [0,0,2,4] and if the string is '))()()(()))' the array is [0,0,0,2,0,4,0,0,2,8,0]
 * So why is this useful? Well the dp array stores previous calculations. If we run into a 0 spot and the character isn't a '('
 * Say we have '))()()' and we start on the last point. The array up til this point is [0,0,0,2,0,_].
 * We notice it's a ) so we decrement one. We find we found a match of '(' so the current is count = 2
 * Then we decrement and see what the longest substring up until that point was. We found that a max length of 2 was there
 * So the total is count + 2 = 4!
 *
 * If instead of a bracket match we found that there was a valid substring, then we add the total at that point to the count
 * And then subtract by that many indices to avoid recalculating them! Then we see if we found another valid substring or a bracket match!
 **/

public class LeetCode_32 {
    public static int longestValidParentheses(String s){

        //msr = max_substring_length (up to the index i). ()()(()) has an msr = [0,2,0,4,0,0,2,8]
        int[] msr = new int[s.length()];
        int max_valid = 0;
        for(int i = 0; i < s.length(); i++){
            int count = 0;

            //If this is a valid end to a substring
            if(s.charAt(i) == ')'){
                int j = i-1;

                //This loops sums up all valid substrings just left of of the ')'
                //The loops ends if it finds an invalid substring or a bracket match (invalid if 0 and ')', match if 0 and '(')
                while(j >= 0 && msr[j] > 0) {
                    count += msr[j];
                    j -= msr[j];
                }

                //So if it's a bracket match we can add two to the count (one for '(' and one for ')')
                //Then at that point we can decrement and add up all the max valid substring prior to that point with just
                //count += d[j-1]. We're not looking for a bracket match so we don't need any loop.
                if(j >= 0 && s.charAt(j) == '('){
                    count += 2;
                    if(j-1 >= 0)
                        count += msr[j-1];
                    msr[i] = count;
                    max_valid = Math.max(count, max_valid);
                }
            }
        }
        return max_valid;
    }
}
