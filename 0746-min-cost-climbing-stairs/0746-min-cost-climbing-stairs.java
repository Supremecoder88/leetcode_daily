import java.util.*;

class Solution {

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return Math.min(
            minCost(0, cost, dp),
            minCost(1, cost, dp)
        );
    }

    static int minCost(int index, int[] cost, int[] dp) {

        // Reached the last step
        if (index >= cost.length) {
            return 0;
        }

        // Already calculated
        if (dp[index] != -1) {
            return dp[index];
        }

        // Take 1 step
        int oneStep = minCost(index + 1, cost, dp);

        // Take 2 steps
        int twoStep = minCost(index + 2, cost, dp);

        dp[index] = cost[index] + Math.min(oneStep, twoStep);

        return dp[index];
    }
}