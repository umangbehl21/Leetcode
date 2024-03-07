package SlidingWindow;

public class LongestRepeatingAndNonOverlappingSubstring {
    
    public static String longestSubstring(String s, int n) {
     int i = 0, j = 0, maxi = 0;
     String ans = "-1";

     while (i < n && j < n) {
         String str = s.substring(i, j + 1);

         if (s.indexOf(str, j + 1) != -1) { //index of finds a string after j+1 index if it is found it returns 1 and j is incremented to check for even greater string 
             if (str.length() > maxi) {
                 maxi = str.length();
                 ans = str;
             }
             j++;
         } else {
             i++;
         }
     }

     return ans;
 }
};

