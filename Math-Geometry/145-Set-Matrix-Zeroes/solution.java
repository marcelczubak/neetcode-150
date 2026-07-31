import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {

        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();

        int R = matrix.length;
        int C = matrix[0].length;

        // Proper traversal
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        // Zero rows
        for (int row : zeroRows) {
            for (int k = 0; k < C; k++) {
                matrix[row][k] = 0;
            }
        }

        // Zero cols
        for (int col : zeroCols) {
            for (int l = 0; l < R; l++) {
                matrix[l][col] = 0;
            }
        }
    }
}