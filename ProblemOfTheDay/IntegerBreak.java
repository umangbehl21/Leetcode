package ProblemOfTheDay;

public class IntegerBreak {
    public int integerBreak(int n) {
        int dp[] = new int[n+1];
        dp[1] = 0;
        dp[2] = 1;
        for(int i = 3;i<dp.length;i++)
        {
            int num = i; 
            for(int j = 1;j<num;j++)
            {
                int split = num - j; 
                int opt1 = Math.max(dp[i],Math.max(split*j , dp[split]*dp[j] )); //for num = 10 it can be break in multiple ways {1,9},{2,8} so on but here we can notice that 2 * 8 is 16 and 2+8 is 10 but now if we further break 8 in 2+3+3 there product will be 2*3*3 i.e 18 * 2 = 36 so we store the maximum product obtained by breaking 8 at dp[8] 
                int opt2 = Math.max(opt1,Math.max(dp[split]*j , split*dp[j] ));
                dp[i] = Math.max(opt1,opt2);
            }
        }
        return dp[n];
    }
}
