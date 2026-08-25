import java.util.*;

class Solution {

    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int lcs = solve(n, m, word1, word2, dp);

        return n + m - (2 * lcs);
    }

    static int solve(int i, int j,
                     String word1, String word2,
                     int[][] dp) {

        // One string is empty
        if (i == 0 || j == 0) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Characters match
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

            dp[i][j] = 1 + solve(
                i - 1,
                j - 1,
                word1,
                word2,
                dp
            );

        } else {

            dp[i][j] = Math.max(
                solve(i - 1, j, word1, word2, dp),
                solve(i, j - 1, word1, word2, dp)
            );
        }

        return dp[i][j];
    }
}