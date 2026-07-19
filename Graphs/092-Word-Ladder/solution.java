import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        

        Map<String, Set<String>> graph = new HashMap<>();
        wordList.add(beginWord);

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i+1; j < wordList.size(); j++) {
                if (differsByOneLetter(wordList.get(i), wordList.get(j))) {
                    graph.putIfAbsent(wordList.get(i), new HashSet<>());
                    graph.putIfAbsent(wordList.get(j), new HashSet<>());
                    graph.get(wordList.get(i)).add(wordList.get(j));
                    graph.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }

        // BFS implementation here
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int numWords = 1;

        queue.offer(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                String word = queue.poll();
                if (word.equals(endWord)) return numWords;

                Set<String> neighbors = graph.getOrDefault(word, new HashSet<>());
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            numWords++;
        }
        return 0;
    }

    private boolean differsByOneLetter(String a, String b) {

        int diff = 0;

        for(int i = 0; i < a.length(); i++) {

            if(a.charAt(i) != b.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return diff == 1;
    }
}   
