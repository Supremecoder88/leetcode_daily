import java.util.*;

class Solution {

    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 1, prices, fee, dp);
    }

    static int solve(int i, int buy,
                     int[] prices, int fee,
                     int[][] dp) {

        // No more days
        if (i == prices.length) {
            return 0;
        }

        // Already calculated
        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }

        int profit;

        if (buy == 1) {

            // Buy
            int take = -prices[i]
                    + solve(i + 1, 0, prices, fee, dp);

            // Don't buy
            int notTake =
                    solve(i + 1, 1, prices, fee, dp);

            profit = Math.max(take, notTake);

        } else {

            // Sell and pay transaction fee
            int sell = prices[i] - fee
                    + solve(i + 1, 1, prices, fee, dp);

            // Don't sell
            int notSell =
                    solve(i + 1, 0, prices, fee, dp);

            profit = Math.max(sell, notSell);
        }

        dp[i][buy] = profit;

        return profit;
    }
}