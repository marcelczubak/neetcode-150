import java.util.*;

class Solution {
    public boolean checkValidString(String s) {
        
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char token = s.charAt(i);

            if (token == '(') leftStack.push(i);
            else if (token == '*') starStack.push(i);
            else {
                if (leftStack.isEmpty() && starStack.isEmpty()) return false;
                else if (!leftStack.isEmpty()) leftStack.pop();
                else  starStack.pop();
            }
        }

        if (starStack.size() < leftStack.size()) return false;

        while (!leftStack.isEmpty() && !starStack.isEmpty()) {

            if (leftStack.pop() > starStack.pop()) return false;

        }
        return true;
    }
}
