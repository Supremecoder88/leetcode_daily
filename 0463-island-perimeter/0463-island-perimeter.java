class Solution {

    public int islandPerimeter(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }

        return 0;
    }

    static int dfs(int[][] grid, int r, int c) {

        // Outside grid = perimeter
        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length) {
            return 1;
        }

        // Water = perimeter
        if (grid[r][c] == 0) {
            return 1;
        }

        // Already visited
        if (grid[r][c] == 2) {
            return 0;
        }

        // Mark visited
        grid[r][c] = 2;

        int perimeter = 0;

        // Up
        perimeter += dfs(grid, r - 1, c);

        // Down
        perimeter += dfs(grid, r + 1, c);

        // Left
        perimeter += dfs(grid, r, c - 1);

        // Right
        perimeter += dfs(grid, r, c + 1);

        return perimeter;
    }
}