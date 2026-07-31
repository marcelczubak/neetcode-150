class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        
        // Reverse matrix vertically (first row becomes last row)
        for (int row = 0; row < n/2; row++) {

            int[] thisRow = matrix[row];
            
            matrix[row] = matrix[n - row - 1];
            matrix[n - row - 1] = thisRow;

        }   

        // Transpose matrix (rows become cols)
        // [r,c] -> [c,r]   (only consider upper triangular, above main diagonal)
        for (int row = 0; row < n; row++) {
            for (int col = row+1; col < n; col++) {

                int thisCell = matrix[row][col];

                matrix[row][col] = matrix[col][row];
                matrix[col][row] = thisCell;
            }
        }

    }
}
