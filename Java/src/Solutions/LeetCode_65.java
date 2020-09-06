package src.Solutions;

import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author : Natalie Dorshimer
 * @since : 1/26/2020, Sun
 **/

/** LeetCode Problem 65: Valid number
 *
 * This returns true if the String s is a valid number (not accounting for whitespaces at beginning and end)
 * Valid strings: "   0   ", "  -343", "  +32",  "-.4e-3. " (most comprehensive example
 * Most comprehensive valid string: "   -.4e-3.  "
 * Invalid string example: "e", "1e", "+ 5", "+-5", "fs 5", "523 sdf"
 *
 * The regex is kind of a mess but that's regex for you
 * Technically leetcode won't except this because it's more comprehensive than the inputs they allowed for
 */
public class LeetCode_65 {

    public static boolean isNumber(String s) {
        // number_reg = "[-+]?(([0-9]+(\\.[0-9]*)?)|([0-9]*(\\.?[0-9]+)))";
        //reg == "\\s*" + number_reg + "(e" + number_reg + ")?" + "\\s*$";

        String reg = "\\s*[-+]?(([0-9]+(\\.[0-9]*)?)|([0-9]*(\\.?[0-9]+)))(e[-+]?(([0-9]+(\\.[0-9]*)?)|([0-9]*(\\.?[0-9]+))))?\\s*$";
        return s.matches(reg);
    }


    @Test
    public void isNumber_test(){
        String test = "0e";
        assert !isNumber(test);
    }

}
