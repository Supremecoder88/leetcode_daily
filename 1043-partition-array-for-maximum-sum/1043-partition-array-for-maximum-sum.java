import java.util.*;

class Solution {

    public int maxSumAfterPartitioning(int[] arr, int k) {

        int n = arr.length;

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(0, arr, k, dp);
    }

    static int solve(int i, int[] arr, int k, int[] dp) {

        // Reached the end
        if (i == arr.length) {
            return 0;
        }

        // Already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        int max = 0;
        int ans = 0;

        // Try partition lengths 1 to k
        for (int j = i; j < arr.length && j < i + k; j++) {

            // Maximum value in current partition
            max = Math.max(max, arr[j]);

            int length = j - i + 1;

            int currentSum = length * max;

            int remaining = solve(j + 1, arr, k, dp);

            ans = Math.max(ans, currentSum + remaining);
        }

        dp[i] = ans;

        return ans;
    }
}