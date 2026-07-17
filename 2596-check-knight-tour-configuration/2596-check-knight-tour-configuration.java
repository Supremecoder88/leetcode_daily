class Solution {

    public boolean checkValidGrid(int[][] grid) {

        int n = grid.length;

        if(grid[0][0] != 0)
            return false;

        int[][] pos = new int[n * n][2];

        // Store position of every number
        for(int i = 0; i < n; i++) {

            for(int j = 0; j < n; j++) {

                int num = grid[i][j];

                pos[num][0] = i;
                pos[num][1] = j;
            }
        }

        // Check every consecutive move
        for(int i = 0; i < n * n - 1; i++) {

            int r1 = pos[i][0];
            int c1 = pos[i][1];

            int r2 = pos[i + 1][0];
            int c2 = pos[i + 1][1];

            int dr = Math.abs(r1 - r2);
            int dc = Math.abs(c1 - c2);

            if(!((dr == 2 && dc == 1) ||
                 (dr == 1 && dc == 2))) {

                return false;
            }
        }

        return true;
    }
}