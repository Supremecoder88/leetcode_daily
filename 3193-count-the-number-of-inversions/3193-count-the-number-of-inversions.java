class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfPermutations(int n, int[][] requirements) {

        int[] req = new int[n];
        Arrays.fill(req, -1);

        int maxInv = 0;
        for (int[] r : requirements) {
            req[r[0]] = r[1];
            maxInv = Math.max(maxInv, r[1]);
        }

        int[][] dp = new int[n + 1][maxInv + 1];
        dp[0][0] = 1;

        for (int len = 1; len <= n; len++) {

            for (int inv = 0; inv <= maxInv; inv++) {

                long ways = 0;

                for (int add = 0; add < len && add <= inv; add++) {
                    ways += dp[len - 1][inv - add];
                }

                dp[len][inv] = (int) (ways % MOD);
            }

            // Apply requirement for prefix of length len
            if (req[len - 1] != -1) {
                for (int inv = 0; inv <= maxInv; inv++) {
                    if (inv != req[len - 1])
                        dp[len][inv] = 0;
                }
            }
        }

        int ans = 0;
        for (int x : dp[n]) {
            ans = (ans + x) % MOD;
        }

        return ans;
    }
}