class Solution {

    public int longestPalindromeSubseq(String s) {

        String rev = new StringBuilder(s).reverse().toString();

        int n = s.length();

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        return solve(n, n, s, rev, dp);
    }

    static int solve(int i, int j, String s, String rev, int[][] dp) {

        // No characters left
        if (i == 0 || j == 0) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Characters match
        if (s.charAt(i - 1) == rev.charAt(j - 1)) {

            dp[i][j] = 1 + solve(
                i - 1,
                j - 1,
                s,
                rev,
                dp
            );

        } else {

            dp[i][j] = Math.max(
                solve(i - 1, j, s, rev, dp),
                solve(i, j - 1, s, rev, dp)
            );
        }

        return dp[i][j];
    }
}