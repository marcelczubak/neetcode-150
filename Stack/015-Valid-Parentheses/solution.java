import java.util.*;

class Solution {
    public boolean isValid(String s) {

        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for (char bracket : s.toCharArray()) {

            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char openBracket = stack.pop();

                if ((bracket == ')' && openBracket != '(') ||
                    (bracket == ']' && openBracket != '[') ||
                    (bracket == '}' && openBracket != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}