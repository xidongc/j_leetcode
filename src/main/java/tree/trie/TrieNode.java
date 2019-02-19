package tree.trie;

import java.util.*;

class TrieNode {

    // R links to node children
    private TrieNode[] links;

    private static final int R = 26;

    private boolean isEnd;

    TrieNode() {
        links = new TrieNode[R];
    }

    boolean contains(char i) {
        return links[i-'a'] != null;
    }

    HashMap<Integer, TrieNode> getAllAvailableLinks() {
        int index = 0;
        HashMap<Integer, TrieNode> hashMap = new HashMap<>();
        for (TrieNode tmpNode: links) {
            if (tmpNode != null) {
                hashMap.put(index, tmpNode);
            }
            index ++;
        }
        return hashMap;
    }

    boolean isEnd() {
        return isEnd;
    }

    void put(char i, TrieNode node) {
        links[i-'a'] = node;
    }

    public TrieNode get(char i) {
        return links[i-'a'];
    }

    void setEnd(boolean end) {
        isEnd = end;
    }
}
