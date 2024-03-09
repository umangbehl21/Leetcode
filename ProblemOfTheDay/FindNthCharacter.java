public class FindNthCharacter {
    public char nthCharacter(String s, int r, int n)
    {
        //code here
        // System.out.println(str);
        int len = s.length();
        for(int i = 0;i<r;i++)
        {
            String str = "";
            for(int j = 0;j<len;j++)  //we have to only change character upto original string length as n will be less than that no need to change every character when size of string keeps on increasing 
            {
                char ch = s.charAt(j);
                if(ch == '0')
                {
                    str += "01";
                }
                else
                {
                    str += "10";
                }
                
            }
            s = str;
        }
        return s.charAt(n);
    }
}
