public class MinimumFallingPathSum { //leetcode 
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        Integer dp[][] = new Integer[matrix.length][matrix.length];
        for(int i = 0;i<matrix[0].length;i++)
        {
            min = Math.min(min,minpathsum(matrix,0,i,dp));
        }
        return min;
    }
    public int minpathsum(int matrix[][],int row,int col,Integer dp[][])
    {
        if(row == -1 || row == matrix.length || col == -1 || col == matrix[0].length)
        {
            return Integer.MAX_VALUE;
        }
        if(dp[row][col] != null)
        {
            return dp[row][col];
        }
        int right = minpathsum(matrix,row+1,col+1,dp);
        int down = minpathsum(matrix,row+1,col,dp);
        int left = minpathsum(matrix,row+1,col-1,dp);
        if(right == Integer.MAX_VALUE && left == Integer.MAX_VALUE && down == Integer.MAX_VALUE)
        {
            return dp[row][col] = matrix[row][col];
        }
        else
        {
            return dp[row][col] = matrix[row][col] + Math.min(down,Math.min(left,right));
        }
    }
}
