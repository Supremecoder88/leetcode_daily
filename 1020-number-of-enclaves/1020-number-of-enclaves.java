class Solution {

    public int numEnclaves(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Remove all land connected to the boundary

        // First and last rows
        for (int j = 0; j < n; j++) {

            if (grid[0][j] == 1)
                dfs(grid, 0, j);

            if (grid[m - 1][j] == 1)
                dfs(grid, m - 1, j);
        }

        // First and last columns
        for (int i = 0; i < m; i++) {

            if (grid[i][0] == 1)
                dfs(grid, i, 0);

            if (grid[i][n - 1] == 1)
                dfs(grid, i, n - 1);
        }

        // Count remaining land
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    static void dfs(int[][] grid, int r, int c) {

        // Outside
        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length) {
            return;
        }

        // Water or already visited
        if (grid[r][c] == 0) {
            return;
        }

        // Mark as removed
        grid[r][c] = 0;

        // 4 directions
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}