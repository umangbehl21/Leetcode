public class Lcs {
    public int longestCommonSubsequence(String s1, String s2) {
        Integer dp[][] = new Integer[s1.length()][s2.length()];
        return lcsHelper(s1,s2,0,0,dp);
    }
    public int lcsHelper(String s1,String s2,int i,int j,Integer dp[][])
    {
        if(i >= s1.length() || j >= s2.length())
        {
            return 0;
        }
        if(dp[i][j] != null)
        {
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j))
        {
            return dp[i][j] = 1 + lcsHelper(s1,s2,i+1,j+1,dp);
        }
        else 
        {
            return dp[i][j] =  Math.max(lcsHelper(s1,s2,i,j+1,dp),lcsHelper(s1,s2,i+1,j,dp));
        }

    }
}
