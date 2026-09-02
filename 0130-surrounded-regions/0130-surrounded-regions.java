class Solution {

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // First row and last row
        for (int j = 0; j < n; j++) {

            if (board[0][j] == 'O') {
                dfs(0, j, board);
            }

            if (board[m - 1][j] == 'O') {
                dfs(m - 1, j, board);
            }
        }

        // First column and last column
        for (int i = 0; i < m; i++) {

            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }

            if (board[i][n - 1] == 'O') {
                dfs(i, n - 1, board);
            }
        }

        // Convert remaining O's to X
        // Convert safe markers back to O
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // Outside the board
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return;
        }

        // Not an O
        if (board[r][c] != 'O') {
            return;
        }

        // Mark as safe
        board[r][c] = '#';

        // Up
        dfs(r - 1, c, board);

        // Down
        dfs(r + 1, c, board);

        // Left
        dfs(r, c - 1, board);

        // Right
        dfs(r, c + 1, board);
    }
}