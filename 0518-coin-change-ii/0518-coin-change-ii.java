import java.util.*;

class Solution {

    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, amount, coins, dp);
    }

    static int solve(int i, int amount,
                     int[] coins, int[][] dp) {

        // Amount made
        if (amount == 0) {
            return 1;
        }

        // No coins left
        if (i == coins.length) {
            return 0;
        }

        // Already calculated
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        // Don't take the current coin
        int notTake = solve(
            i + 1,
            amount,
            coins,
            dp
        );

        // Take the current coin
        int take = 0;

        if (coins[i] <= amount) {

            // i stays same because coin can be used again
            take = solve(
                i,
                amount - coins[i],
                coins,
                dp
            );
        }

        dp[i][amount] = take + notTake;

        return dp[i][amount];
    }
}