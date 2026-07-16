import java.util.*;

class Solution {

    Map<Integer, List<Character>> telephoneMapping = Map.of(
        2, Arrays.asList('a','b','c'),
        3, Arrays.asList('d','e','f'),
        4, Arrays.asList('g','h','i'),
        5, Arrays.asList('j','k','l'),
        6, Arrays.asList('m','n','o'),
        7, Arrays.asList('p','q','r','s'),
        8, Arrays.asList('t','u','v'),
        9, Arrays.asList('w','x','y','z')
    );


    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        backtrack(result, new StringBuilder(), digits, 0);

        return result;
    }

    private void backtrack(List<String> result, StringBuilder combination, String digits, int digitsIndex) {    

        if (digitsIndex == digits.length()) {
            result.add(combination.toString());
            return;
        }

        char digit = digits.charAt(digitsIndex);
        List<Character> letters = telephoneMapping.get(digit - '0');

        for (char letter : letters) {
            combination.append(letter);

            backtrack(result, combination, digits, digitsIndex+1);

            combination.deleteCharAt(combination.length() - 1);
        }
    }
}