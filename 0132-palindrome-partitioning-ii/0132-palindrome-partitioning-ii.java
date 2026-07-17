class Solution {

    public int minCut(String s) {

        int n = s.length();

        boolean[][] pal = new boolean[n][n];

        // Build palindrome table
        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j) &&
                        (j - i < 2 || pal[i + 1][j - 1])) {

                    pal[i][j] = true;
                }
            }
        }

        int[] dp = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            dp[i] = Integer.MAX_VALUE;

            for (int j = i; j < n; j++) {

                if (pal[i][j]) {

                    if (j == n - 1) {

                        dp[i] = 0;

                    } else {

                        dp[i] = Math.min(dp[i],
                                1 + dp[j + 1]);
                    }
                }
            }
        }

        return dp[0];
    }
}