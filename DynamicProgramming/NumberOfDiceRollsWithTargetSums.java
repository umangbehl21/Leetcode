package DynamicProgramming;

import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSums {
    private final long M = 1000000007;
    private int[][] t = new int[32][1002];

    public int solve(int n, int k, int target) {
        if (target < 0 || n == 0)
            return target == 0 ? 1 : 0;

        if (t[n][target] != -1)
            return t[n][target];

        int sum = 0;

        for (int face = 1; face <= k; face++) {
            sum = (sum + solve(n - 1, k, target - face)) % (int) M;
        }

        return t[n][target] = sum;
    }

    public int numRollsToTarget(int n, int k, int target) {
        for (int i = 0; i < 32; i++) {
            Arrays.fill(t[i], -1);
        }
        return solve(n, k, target);
    }
}