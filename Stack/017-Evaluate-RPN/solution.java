import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (isOperator(token)) {

                int a = stack.pop();
                int b = stack.pop();

                stack.push(evaluate(b, a, token));

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") ||
               token.equals("-") ||
               token.equals("*") ||
               token.equals("/");
    }

    private int evaluate(int b, int a, String op) {
        switch (op) {
            case "+":
                return b + a;
            case "-":
                return b - a;
            case "*":
                return b * a;
            case "/":
                return b / a;
        }
        return 0;
    }
}