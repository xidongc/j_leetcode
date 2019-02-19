package tree.trie;

import java.util.*;
import java.util.stream.Collectors;

class ReplaceWords {

    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();

        for (String d: dict) {
            System.out.println(d);
            trie.insert(d);
        }

        String[] input = sentence.split(" ");
        for (int i=0; i<input.length; ++i) {
            String prefix = trie.findLongestPrefix(input[i]);
            if (prefix != null) {
                input[i] = prefix;
            }
        }
        return Arrays.stream(input).collect(Collectors.joining(" "));
    }

}
