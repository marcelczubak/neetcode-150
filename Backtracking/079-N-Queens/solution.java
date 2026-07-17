import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();

        List<List<String>> result = new ArrayList<>();

        char[][] initialBoard = new char[n][n];
        for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    initialBoard[i][j] = '.';
                }
            }

        backtrack(result, initialBoard, n, 0, cols, posDiag, negDiag);

        return result;
    }

    private void backtrack(List<List<String>> result, char[][] board, int n, int row, Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag) {

        if (row == n) {
            
            List<String> oneGrid = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringBuilder oneRow = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    oneRow.append(board[i][j]);
                }
                oneGrid.add(oneRow.toString());
            }
            
            // One valid solution
            result.add(oneGrid);
            return;
        }

        for (int col = 0; col < n; col++) {

            if (cols.contains(col) || posDiag.contains(row+col) || negDiag.contains(row-col)) continue;

            cols.add(col);
            posDiag.add(row+col);
            negDiag.add(row-col);

            // Place queen
            board[row][col] = 'Q';

            backtrack(result, board, n, row+1, cols, posDiag, negDiag);

            cols.remove(col);
            posDiag.remove(row+col);
            negDiag.remove(row-col);

            // Remove queen
            board[row][col] = '.';

        }
    }
}
