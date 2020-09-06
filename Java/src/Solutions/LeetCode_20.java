/**
 * @author : Natalie Dorshimer
 * @since : 1/19/20
 *
 *
 * LeetCode Problem 20: Valid parentheses
 *
 * Given a string of only brackets (ex "[{]]][[()"), create a function that returns if all brackets are properly matched
 *
 * This is pretty easy to do with stacks. Push the left brackets onto the stack, and if you run into a right bracket,
 * Pop off the stack and see if they're matching brackets. If they're not, it's not valid. If all brackets are matched,
 * the stack will be empty at the end.
 * Ex: "[({})]
 *  Stack: _ -> [ -> [( -> [({ -> [( {} -> [ () -> [] -> _
**/

package src.Solutions;

import java.util.Stack;

public class LeetCode_20 {
    
    public static boolean isValid(String s) {
        Stack<Character> chars = new Stack();
        for(int i = 0; i < s.length(); i++){
            char s_char = s.charAt(i);
            if(isRightBracket(s_char)) {
                if (chars.isEmpty())
                    return false;
                if(!isMatched(chars.pop(),s_char))
                    return false;
            }
            else
                chars.push(s_char);
        }
        return chars.isEmpty();
    }

    public static boolean isRightBracket(char c){
        return c == '}' || c == ']' || c ==  ')';
    }

    //Returns true if the left bracket matches the right bracket
    public static boolean isMatched(char left, char right) {
        if(left == '(' && right != ')')
            return false;
        if(left == '[' && right != ']')
            return false;
        if(left == '{' && right != '}')
            return false;

        return true;
    }
}