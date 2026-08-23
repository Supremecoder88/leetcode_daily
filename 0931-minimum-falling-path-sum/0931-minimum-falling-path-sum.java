import java.util.*;

class Solution {

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int answer = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            answer = Math.min(
                answer,
                minPath(0, j, matrix, dp)
            );
        }

        return answer;
    }

    static int minPath(int i, int j,
                       int[][] matrix, int[][] dp) {

        // Outside the column
        if (j < 0 || j >= matrix.length) {
            return 1000000000;
        }

        // Last row
        if (i == matrix.length - 1) {
            return matrix[i][j];
        }

        // Already calculated
        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int down = minPath(i + 1, j, matrix, dp);

        int left = minPath(i + 1, j - 1, matrix, dp);

        int right = minPath(i + 1, j + 1, matrix, dp);

        dp[i][j] = matrix[i][j]
                 + Math.min(down, Math.min(left, right));

        return dp[i][j];
    }
}