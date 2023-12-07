public class LongestOddNum {
    public String largestOddNumber(String num) {
        int i = num.length() - 1;

       // Find the first odd digit from the end
       while (i >= 0 && (num.charAt(i) - '0') % 2 == 0) {
           i--;
       }

       // If no odd digit is found, return an empty string
       if (i < 0) {
           return "";
       }

       // Return the substring from the beginning of the string to the index of the first odd digit
       return num.substring(0, i + 1);
   }
}
