package tree.trie;

import tree.binaryTree.TreeNode;

public class MagicDictionary {

    private Trie trie;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        trie = new Trie();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String d: dict) {
            trie.insert(d);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        TrieNode node = trie.getRoot();
        return searchHelper(word, 1, node);
    }

    private boolean searchHelper(String word, int tolerant, TrieNode node) {
        if (word.length() == 0) {
            return node.isEnd() && (tolerant == 0);
        } else {
            if (!node.contains(word.charAt(0))) {
                if (tolerant == 0) {
                    return false;
                } else {
                    boolean condition2 = false;
                    for (TrieNode tmpNode : node.getAllAvailableLinks().values()) {
                        tolerant--;
                        condition2 = condition2 || searchHelper(word.substring(1), tolerant, tmpNode);
                        tolerant++;
                    }
                    return condition2;
                }
            } else {
                boolean condition1 = false;
                for (TrieNode tmpNode: node.getAllAvailableLinks().values()) {
                    if (tmpNode == node.get(word.charAt(0))) {
                        condition1 = condition1 || searchHelper(word.substring(1), tolerant, tmpNode);
                    } else {
                        tolerant--;
                        condition1 = condition1 || searchHelper(word.substring(1), tolerant, tmpNode);
                        tolerant++;
                    }
                }
                return condition1;
            }
        }
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 *
 * Input: buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 */
