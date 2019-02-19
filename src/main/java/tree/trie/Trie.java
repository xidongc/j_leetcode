package tree.trie;

class Trie {

    private TrieNode root;

    public TrieNode getRoot(){
        return root;
    }

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for (int i=0; i<word.length(); ++i) {
            char currChar = word.charAt(i);
            if (!node.contains(currChar)) {
                node.put(currChar, new TrieNode());
            }
            node = node.get(currChar);
        }
        node.setEnd(true);
    }

    private TrieNode searchWithPrefix(String word) {
        TrieNode node = root;
        for (int i=0; i<word.length(); ++i) {
            char currChar = word.charAt(i);
            if (node.contains(currChar)){
                node = node.get(currChar);
            } else {
                return null;
            }
        }
        return node;
    }

    boolean search(String word) {
        TrieNode node = searchWithPrefix(word);
        return node != null && node.isEnd();
    }

    boolean startWith(String word) {
        TrieNode node = searchWithPrefix(word);
        return node != null;
    }

    String findLongestPrefix(String input) {
        TrieNode node = root;
        String longestPrefix = null;
        for (int i=0; i<input.length(); ++i) {
            if (node.contains(input.charAt(i))) {
                node = node.get(input.charAt(i));
                if (node.isEnd()) {
                    longestPrefix = input.substring(0,i+1);
                    break;
                }
            } else {
                return null;
            }
        }
        return longestPrefix;
    }

}
