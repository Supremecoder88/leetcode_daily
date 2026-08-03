class Solution {

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;

        // Add all rotten oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});

                else if (grid[i][j] == 1)
                    fresh++;
            }
        }

        if (fresh == 0)
            return 0;

        int minutes = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean rottenThisMinute = false;

            for (int i = 0; i < size; i++) {

                int[] cell = queue.poll();

                int r = cell[0];
                int c = cell[1];

                for (int d = 0; d < 4; d++) {

                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr >= 0 && nr < rows &&
                        nc >= 0 && nc < cols &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;

                        queue.offer(new int[]{nr, nc});

                        rottenThisMinute = true;
                    }
                }
            }

            if (rottenThisMinute)
                minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}