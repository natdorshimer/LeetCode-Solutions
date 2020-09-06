package src.Solutions;

public class LeetCode_28 {
    public static int strStr(String haystack, String needle) {
        if(needle.compareTo("") == 0)
            return 0;
    
        for(int i = 0; i <= haystack.length()-needle.length(); i++)
            if(needle.compareTo(haystack.substring(i,i+needle.length())) == 0)
                return i;
        
        return -1;
    }
}