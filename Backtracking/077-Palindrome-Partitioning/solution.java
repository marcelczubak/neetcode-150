import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), s, 0);

        return result;
    }

    private void backtrack(List<List<String>> result, List<String> currentPartition, String s, int start) {

        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        // Try every possible substring
        for (int end = start; end < s.length(); end++) {
            String substring = s.substring(start, end+1);

            if(isPalindrome(substring)) {

                currentPartition.add(substring);
                backtrack(result, currentPartition, s, end+1);

                currentPartition.remove(currentPartition.size() - 1);       
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while (left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}