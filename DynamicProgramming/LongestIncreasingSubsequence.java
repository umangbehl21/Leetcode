public class LongestIncreasingSubsequence {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int dp[] = new int[nums.length];
            for(int i = 0;i<dp.length;i++)
            {
                dp[i] = 1;
            }
            int maxlis = Integer.MIN_VALUE;
            for(int i = 0;i<dp.length;i++)
            {
                for(int j = 0;j<i;j++)
                {
                    if(nums[j] < nums[i])
                    {
                        dp[i] = Math.max(dp[i],dp[j]+1);
                        maxlis = Math.max(maxlis,dp[i]);
                    }
                }
            }
            if(maxlis == Integer.MIN_VALUE)
            {
                return 1;
            }
            else 
            {
                return maxlis;
            }
        }
    }
    class memo { //memoization recursion 
           private int n;
        private int[][] t;
    
        public int lis(int[] nums, int prevIdx, int currIdx) {
            if (currIdx == n) {
                return 0;
            }
    
            if (prevIdx != -1 && t[prevIdx][currIdx] != -1) {
                return t[prevIdx][currIdx];
            }
    
            int taken = 0;
            if (prevIdx == -1 || nums[currIdx] > nums[prevIdx]) {
                taken = 1 + lis(nums, currIdx, currIdx + 1);
            }
    
            int notTaken = lis(nums, prevIdx, currIdx + 1);
    
            if (prevIdx != -1) {
                t[prevIdx][currIdx] = Math.max(taken, notTaken);
            }
    
            return Math.max(taken, notTaken);
        }
    
        public int lengthOfLIS(int[] nums) {
            n = nums.length;
            t = new int[n + 1][n + 1];
            for (int[] row : t) {
                Arrays.fill(row, -1);
            }
            return lis(nums, -1, 0);
        }
    }
}
