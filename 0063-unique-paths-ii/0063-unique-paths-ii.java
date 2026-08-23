class Solution {

    public int uniquePathsWithObstacles(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return paths(0, 0, grid, dp);
    }

    static int paths(int i, int j, int[][] grid, int[][] dp) {

        // Outside the grid
        if (i >= grid.length || j >= grid[0].length) {
            return 0;
        }

        // Obstacle
        if (grid[i][j] == 1) {
            return 0;
        }

        // Reached destination
        if (i == grid.length - 1 &&
            j == grid[0].length - 1) {
            return 1;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Move down
        int down = paths(i + 1, j, grid, dp);

        // Move right
        int right = paths(i, j + 1, grid, dp);

        dp[i][j] = down + right;

        return dp[i][j];
    }
}