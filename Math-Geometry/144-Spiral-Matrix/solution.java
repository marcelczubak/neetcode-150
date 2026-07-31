import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        long total = (long) rows * cols;

        List<Integer> result = new ArrayList<>();

        int topRow = 0;
        int leftCol = 0;

        int bottomRow;
        int rightCol;
        
        while (result.size() < total) {

            rightCol = cols - leftCol - 1;
            bottomRow = rows - topRow - 1;


            // Add elements in the top row
            for (int col = leftCol; col <= rightCol; col++) {
                result.add(matrix[topRow][col]);
            }


            // Add elements in the right column
            for (int row = topRow + 1; row <= bottomRow; row++) {
                result.add(matrix[row][rightCol]);
            }


            // Add elements in the bottom row
            // Only if there is still a remaining row
            if (bottomRow > topRow) {
                for (int col = rightCol - 1; col >= leftCol; col--) {
                    result.add(matrix[bottomRow][col]);
                }
            }


            // Add elements in the left column
            // Only if there is still a remaining column
            if (rightCol > leftCol) {
                for (int row = bottomRow - 1; row > topRow; row--) {
                    result.add(matrix[row][leftCol]);
                }
            }

            // Move into next layer
            topRow++;
            leftCol++;
        }

        return result;
    }
}