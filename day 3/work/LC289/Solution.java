class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int live = 0;

                for (int r = i - 1; r <= i + 1; r++) {
                    for (int c = j - 1; c <= j + 1; c++) {

                        if (r >= 0 && r < m && c >= 0 && c < n) {
                            if (!(r == i && c == j) && board[r][c] == 1) {
                                live++;
                            }
                        }
                    }
                }

                if (board[i][j] == 1) {
                    if (live == 2 || live == 3) {
                        ans[i][j] = 1;
                    }
                } else {
                    if (live == 3) {
                        ans[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ans[i][j];
            }
        }
    }
}