package DynamicProgramming;

public class FrogJump {

    public static int frogJump(int n, int heights[]) {
        // Write your code here..
        int dp[] = new int[n];
        dp[0] = 0; //at 0th stair where there is no progress energy spent is 0 
        for(int i = 1;i<n;i++)
        {
            int fstep = dp[i-1] + Math.abs(heights[i] - heights[i-1]); //energy spent till i-1th stair + energy spent from i - 1th stair to ith stair 
            int secstep = Integer.MAX_VALUE;
            if(i > 1) //if index is one and we move two index back it will try to access -1 index which is index out of bound 
            secstep = dp[i-2] + Math.abs(heights[i] - heights[i-2]); //enery spent till i-2th stair + energy spent from i-2th stair to ith index 
            dp[i] = Math.min(fstep, secstep);  //minimum between the first step and second step is minimum energy spent so it will be stored as the energy to reach the ith stair 
        } 
      return dp[n-1];
    }
    
}
