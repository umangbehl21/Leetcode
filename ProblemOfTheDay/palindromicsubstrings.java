class Solution {
   
    public int countSubstrings(String s) {
        int total = 0;
        int i = 0;
        int j = 0;
        while(i < s.length())
        {
            j = i;
            while(j < s.length())
            {
                total += checkpalindrome(s.substring(i,j+1));
                j++;
            }
            i++;
        }
        return total;
    }
    public int checkpalindrome(String s)
    {
        int i = 0;
        int j = s.length()-1;
        while(i < j)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return 0;
            }
            i++;
            j--;
        }
        return 1;
    }
}