package DynamicProgramming;

import java.util.Arrays;

public class Kfrogjumps { //https://www.codingninjas.com/studio/problems/minimal-cost_8180930?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0
    
    public class Solution {
    public static int minimizeCost(int n, int k, int []height){
        int dp[] = new int[height.length];
        Arrays.fill(dp,-1);
        return mincosthelp(height,k,dp,height.length-1);
    }
    public static int mincosthelp(int height[],int k,int dp[],int ind)
    {
       if(dp[ind] != -1)
        {
            return dp[ind];
        }
        if(ind == 0)
        {
            dp[ind] = 0;
            return dp[ind];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1;i<=k;i++)
        {
         if(ind - i < 0) break;
         
          min = Math.min(min,Math.abs(height[ind] - height[ind - i])+mincosthelp(height, k, dp, ind - i));
        }
        dp[ind] = min;
        return dp[ind];
    }
}
//DP SOLUTION BELOW
/**   public static int minimizeCost(int n, int k, int []height) {

        // Initialize 'dp' array to store minimum cost at each position.
        int []dp = new int[n];
        dp[0] = 0;

        // Set all other elements in 'dp' to infinity.
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // Iterate through each position starting from the second position.
        for (int i = 1; i < n; i++) {
            // Iterate through possible jumps from 1 to 'k'.
            for (int j = 1; j <= k; j++) {
                // Skip if the current position minus the jump is out of bounds.
                if (i - j < 0) {
                    continue;
                }
                // Update the minimum cost at the current position.
                dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(height[i] - height[i - j]));
            }
        }

        // Return the minimum cost at the last position.
        return dp[n - 1];
    } **/
}
