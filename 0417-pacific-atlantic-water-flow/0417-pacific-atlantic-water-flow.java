import java.util.*;

class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific: top row + left column
        for (int i = 0; i < m; i++) {
            dfs(i, 0, heights, pacific);
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, heights, pacific);
        }

        // Atlantic: bottom row + right column
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, heights, atlantic);
        }

        for (int j = 0; j < n; j++) {
            dfs(m - 1, j, heights, atlantic);
        }

        // Find cells reachable from both oceans
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(
        int r,
        int c,
        int[][] heights,
        boolean[][] ocean
    ) {

        // Already visited
        if (ocean[r][c]) {
            return;
        }

        ocean[r][c] = true;

        int[][] directions = {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1}   // right
        };

        for (int[] dir : directions) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            // Outside grid
            if (nr < 0 || nr >= heights.length ||
                nc < 0 || nc >= heights[0].length) {
                continue;
            }

            // Reverse flow:
            // next cell must be >= current cell
            if (heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, heights, ocean);
            }
        }
    }
}