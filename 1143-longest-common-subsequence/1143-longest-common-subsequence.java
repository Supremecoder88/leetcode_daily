import java.util.*;

class Solution {

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return lcs(0, 0, text1, text2, dp);
    }

    static int lcs(int i, int j,
                   String text1, String text2,
                   int[][] dp) {

        // Reached end of either string
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Characters are same
        if (text1.charAt(i) == text2.charAt(j)) {

            dp[i][j] = 1 + lcs(
                i + 1,
                j + 1,
                text1,
                text2,
                dp
            );

        } 
        // Characters are different
        else {

            dp[i][j] = Math.max(
                lcs(i + 1, j, text1, text2, dp),
                lcs(i, j + 1, text1, text2, dp)
            );
        }

        return dp[i][j];
    }
}