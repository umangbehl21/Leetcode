import java.util.Arrays;

public class CountPossibleWaysToconstructBuilding { //https://www.geeksforgeeks.org/problems/count-possible-ways-to-construct-buildings5007/1
    int[][] t;
    int M = (int) (1e9 + 7);

    int space = 0;
    int building = 1;
    
    public int solve(int n, int status) {
        if (n == 0)
            return 1; // All done. Found one way

        if (t[n][status] != -1)
            return t[n][status];

        if (status == building)
            return t[n][status] = solve(n - 1, space) % M;
        else
            return t[n][status] = (solve(n - 1, building) % M + solve(n - 1, space) % M) % M;
    }
    
    public int TotalWays(int N) {
        t = new int[N + 1][2];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(t[i], -1);
        }

        long x = (solve(N - 1, building) % M + solve(N - 1, space) % M) % M;

        return (int) ((x * x) % M);
    }
}




