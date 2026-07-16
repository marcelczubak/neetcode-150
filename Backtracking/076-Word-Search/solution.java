class Solution {
    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (dfs(board, word, row, col, 0, visited)) return true;
            }
        }
        return false;
    }


    // Depth First Approach
    private boolean dfs(char[][] board, String word, int row, int col, int index, boolean[][] visited) {

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]) return false;
        if (board[row][col] != word.charAt(index)) return false;
        if (index == word.length() - 1) return true;

        // Visit this cell
        visited[row][col] = true;

        // Can move further? 
        boolean found = (dfs(board, word, row+1, col, index+1, visited) || dfs(board, word, row-1, col, index+1, visited) || dfs(board, word, row, col+1, index+1, visited) || dfs(board, word, row, col-1, index+1, visited));

        // Undo visited state (backtrack)
        visited[row][col] = false;

        // THEN, return
        return found;
    }
}
