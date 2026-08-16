import java.util.*;

class Solution {

    StringBuilder result = new StringBuilder();

    public String foreignDictionary(String[] words) {
      
        Map<Character, List<Character>> graph = new HashMap<>();

        // Go through every word and add every character
        for (String word : words) {
            for (char c : word.toCharArray()) graph.putIfAbsent(c, new ArrayList<>());
        }

        for (int i = 1; i < words.length; i++) {

            String a = words[i-1];
            String b = words[i];

            boolean foundDifference = false;

            for (int c = 0; c < Math.min(a.length(), b.length()); c++) {

                if (a.charAt(c) == b.charAt(c)) continue;

                graph.get(a.charAt(c)).add(b.charAt(c));
                
                foundDifference = true;

                // Ordering determined... no need to continue
                break;
            } 
            if (!foundDifference && a.length() > b.length()) return "";
        }

        // Return any valid solution
        // {0: unvisited, 1: currently visiting, 2: complete}
        Map<Character, Integer> state = new HashMap<>();

        for (Character c : graph.keySet()) {
            if (dfs(graph, state, c)) return ""; // cycle
        }

        return result.reverse().toString();
    }

    private boolean dfs(Map<Character, List<Character>> graph, Map<Character, Integer> state, Character c) 
{
        if (state.containsKey(c)) {
            // Already processed? 
            if (state.get(c) == 2) return false;
            // In this recursion path?
            if (state.get(c) == 1) return true; // Cycle
        }

        // Mark as currently visiting
        state.put(c, 1);

        // DFS all neighbors
        List<Character> neighbors = graph.getOrDefault(c, new ArrayList<>());
        for (Character neighbor : neighbors) if (dfs(graph, state, neighbor)) return true;
        
        // Mark this char as completely processed
        state.put(c, 2);

        // Add c to result
        result.append(c);

        // No cycle...
        return false;
    }
}
