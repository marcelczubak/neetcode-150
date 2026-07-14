import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; // equivalent to an ending flag 
    }

    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void addWord(String word) {

            TrieNode curr = root;

            for (char c : word.toCharArray()) {

                int index = c - 'a';

                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }

                curr = curr.children[index];
            }
            curr.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        
        Trie trie = new Trie();

        List<String> result = new ArrayList<>();

        // Populate a trie with all the words
        for (String word : words) {
            trie.addWord(word);
        }

        // Traverse the board
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                dfs(board, row, col, trie.root, result);

            }
        }

        return result;

    }

    private void dfs(char[][] board, int row, int col, TrieNode node, List<String> result) {
        // Check if valid
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '#') return;

        // Get character and index
        char c = board[row][col];
        int index = c - 'a';

        // If no trie child, return
        if (node.children[index] == null) return;
        else node = node.children[index];

        // If trie node contains word, add answer
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        // Visit cell
        board[row][col] = '#';

        // Explore up down left right
        dfs(board, row+1, col, node, result);
        dfs(board, row-1, col, node, result);
        dfs(board, row, col-1, node, result);
        dfs(board, row, col+1, node, result);

        // Restore board cell
        board[row][col] = c;

        
    }
}