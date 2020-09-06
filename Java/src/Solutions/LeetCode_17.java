/**
 * @author : Natalie Dorshimer
 * @since : 1/19/20
 *
 *
 * LeetCode Problem 17: Letter Combinations of a phone number
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number
     * could represent. A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1
     * does not map to any letters.
 *
 * The easiest way to do this problem would be by calculating the cartesian product of the starting set with
 * the set that maps to each consecutive digit. So 23 would be the cartesian product of (a,b,c) and (d,e,f) since
 * order is maintained in the cartesian product.
 *
 * My solution essentially performs the cartesian product element by element by taking each input of the first set,
 * tacking on every single element of the second set to it and then going to the next input of the first set and repeating.
 * There's probably a cleaner method in python by using products but this works fine.
 *
**/

package src.Solutions;

import java.util.*;

public class LeetCode_17 {

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<>(); //To avoid array resizing and we're doing O(n) through every time anyway
        List<Character>[] digit_map = new List[10];

        digit_map[2] = Arrays.asList('a','b','c');
        digit_map[3] = Arrays.asList('d','e','f');
        digit_map[4] = Arrays.asList('g','h','i');
        digit_map[5] = Arrays.asList('j','k','l');
        digit_map[6] = Arrays.asList('m','n','o');
        digit_map[7] = Arrays.asList('p','q','r','s');
        digit_map[8] = Arrays.asList('t','u','v');
        digit_map[9] = Arrays.asList('w','x','y','z');

        //This initializes the answer array that will allow us to perform an algorithm on
        if(ans.isEmpty() && digits.length() > 0)
            for(char c : digit_map[digits.charAt(0) - '0'])
                ans.add(Character.toString(c));

        for(int i = 1; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            List<String> newList = new LinkedList<>();

            //Performs the cartesian product of ans and digit_map[num] using newList as a work list
            for (char c : digit_map[num]) {
                for (String s : ans) {
                    s += c;
                    newList.add(s);
                }
            }
            ans = newList;
        }
        return ans;
    }
}