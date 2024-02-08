public class perfectsquare {
    public int numSquares(int n) {
        Integer dp[] = new Integer[n+1];
        return minsqhelp(n,dp);
    }
    public int minsqhelp(int n,Integer dp[])  //we need the minimum number of perfect squares that sum to n 
    {
        if(n == 0)
        {
            return 0;
        }
        if(dp[n] != null)
        {
            return dp[n];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1;i*i<=n;i++)
        {   
            int result = 1 + minsqhelp(n - i * i,dp);
            min = Math.min(result,min);
        }
        return dp[n] = min;
    }
}
