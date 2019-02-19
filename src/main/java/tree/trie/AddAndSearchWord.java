package tree.trie;

import java.util.Map;

public class AddAndSearchWord {
    private Trie trie;

    /** Initialize your data structure here. */
    public AddAndSearchWord() {
        trie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to repAresent any one letter. */
    public boolean search(String word) {
        TrieNode node = trie.getRoot();
        return searchWithDfs(word, node);
    }

    private boolean searchWithDfs(String word, TrieNode curr) {
        if (word.length() == 0 && curr.isEnd()) {
            return true;
        } else if (word.length() != 0) {
            char currChar = word.charAt(0);
            if (currChar != '.' && curr.contains(currChar)) {
                curr = curr.get(currChar);
                return searchWithDfs(word.substring(1), curr);
            } else if (currChar == '.') {
                boolean condition = false;
                if (curr.getAllAvailableLinks()== null) {
                    return condition;
                }
                for (TrieNode ele: curr.getAllAvailableLinks().values()) {
                    condition = condition || searchWithDfs(word.substring(1), ele);
                }
                return condition;
            }
            return false;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
