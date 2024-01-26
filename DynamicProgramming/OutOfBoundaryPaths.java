import java.util.Arrays;

public class OutOfBoundaryPaths {
    class Solution {
    int trows;
    int tcol;
    int mod = 1000000007;
    Integer[][][] dp; 

    public int findPaths(int m, int n, int maxMove, int startRow, int startCol) { //dfs + dp 
        trows = m;
        tcol = n;
        dp = new Integer[trows][tcol][maxMove + 1];
        return solve(startRow, startCol, maxMove);
    }

    public int solve(int startRow, int startCol, int maxMove) {
        if (startRow < 0 || startRow >= trows || startCol < 0 || startCol >= tcol) {
            return 1;
        }
        if (maxMove <= 0) {
            return 0;
        }
        if (dp[startRow][startCol][maxMove] != null) {
            return dp[startRow][startCol][maxMove];
        }

        int up = solve(startRow - 1, startCol, maxMove - 1) % mod;
        int down = solve(startRow + 1, startCol, maxMove - 1) % mod;
        int left = solve(startRow, startCol - 1, maxMove - 1) % mod;
        int right = solve(startRow, startCol + 1, maxMove - 1) % mod;

       
        dp[startRow][startCol][maxMove] = (((((left + right) % mod) + down) % mod) + up) % mod;

        return dp[startRow][startCol][maxMove];
    }
}

}
