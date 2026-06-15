import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // Iterate rows
        for (int i = 0; i < 9; i++) {

            Set<Character> set = new HashSet<>();

            for (int j = 0; j < 9; j++) {

                char c = board[i][j];

                if (c == '.') continue;
                
                if (set.contains(c)) return false;
                else set.add(c);
            }
        }

        // Iterate cols
        for (int i = 0; i < 9; i++) {

            Set<Character> set = new HashSet<>();

            for (int j = 0; j < 9; j++) {

                char c = board[j][i];

                if (c == '.') continue;

                if (set.contains(c)) return false;
                else set.add(c);
            }
        }

        // Iterate subgrids ... Note: starting cells: (0,0) (0,3) (0,6) (3,0) (3,3) (3,6) (6,0) (6,3) (6,6)
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {

                Set<Character> set = new HashSet<>();

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        char c = board[boxRow * 3 + i][boxCol * 3 + j];

                        if (c == '.') continue;

                        if (set.contains(c)) return false;

                        set.add(c);
                    }
                }
            }
        }

        return true;
    }
}
