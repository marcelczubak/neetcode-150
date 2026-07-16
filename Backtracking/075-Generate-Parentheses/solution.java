import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();

        backtrack(result, 0, 0, n, new StringBuilder());

        return result;
    }

    private void backtrack(List<String> result, int open, int close, int n, StringBuilder current) {
        // Length of string exhausted ... save and return
        if (current.length() == 2*n) {
            result.add(current.toString());
            return;
        }
        
        // Opening bracket can be added
        if (open < n) {
            current.append('(');
            backtrack(result, open+1, close, n, current);
            current.deleteCharAt(current.length() - 1);
        }

        // Closing bracket to be added to complement the opening bracket
        if (close < open) { 
            current.append(')');
            backtrack(result, open, close+1, n, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
