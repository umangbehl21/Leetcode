package ProblemOfTheDay;

public class Largest3sumDigitNumInString { //leetcode 2264
    public String largestGoodInteger(String num) {
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        while(j<num.length())
        {
            char c = num.charAt(j);
            while(j<num.length() && num.charAt(j) == c)
            {
                 if(j-i + 1 == 3)
                {
                    String s = num.substring(i,j + 1);
                    int n = Integer.parseInt(s);
                    if(n > max)
                    {
                        max = n;
                    }
                    i = j;
                    j++;
                    break;
                }
                j++;
            }
               if(j - i == 2)
                {
                    i = j;
                    continue;
                }
            i++;
        }
        if(max == 0)
        {
            return "000";
        }
        if(max == Integer.MIN_VALUE)
        {
            return "";
        }
        return Integer.toString(max);
    }
}
