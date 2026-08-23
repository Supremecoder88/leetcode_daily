import java.util.*;

class Solution {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return paths(0, 0, m, n, dp);
    }

    static int paths(int i, int j, int m, int n, int[][] dp) {

        // Reached destination
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Outside grid
        if (i >= m || j >= n) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Move down
        int down = paths(i + 1, j, m, n, dp);

        // Move right
        int right = paths(i, j + 1, m, n, dp);

        dp[i][j] = down + right;

        return dp[i][j];
    }
}