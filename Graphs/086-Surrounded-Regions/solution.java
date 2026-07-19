class Solution {
    public void solve(char[][] board) {
        
        // Run DFS from borders
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if  (row == 0 || col == 0 || row == board.length-1 || col == board[0].length -1) {
                    dfs(board, row, col);
                }
            }
        }

        // When DFS returns, mark Os as X, and marked cells M back to O
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'O') board[row][col] = 'X';
                if (board[row][col] == 'M') board[row][col] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') return;
        
        board[row][col] = 'M';

        dfs(board, row+1, col);
        dfs(board, row-1, col);
        dfs(board, row, col+1);
        dfs(board, row, col-1);
    }

}
