class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
        root.endOfWord = false;
    }

    public void addWord(String word) {

        TrieNode curr = root;

        // Iterate through the characters of the word
        for (char c : word.toCharArray()) {

            int index = c - 'a';

            // Does child exist?
            if (curr.children[index] != null) {
                // Move there
                curr = curr.children[index];
            } else {
                // Create child
                TrieNode child = new TrieNode();
                curr.children[index] = child;
                // Move there
                curr = child;
            }
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        // If end of word potentially reached
        if (index == word.length()) return node.endOfWord;

        char c = word.charAt(index);

        // Wildcard
        if (c == '.') {
            // Try all children
            for (TrieNode child : node.children) {
                // Try next indices recursively
                if (child != null && dfs(word, index+1, child)) return true;
            }
            return false;

        // Other letter
        } else {
            int i = c - 'a';

            if (node.children[i] == null) return false;
            
            return dfs(word, index+1, node.children[i]);
        }
    }

}

