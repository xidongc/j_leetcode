package string;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> relation = new HashMap<>();
        relation.put('(', ')');
        relation.put('[', ']');
        relation.put('{', '}');

        Stack<Character> stack = new Stack<>();

        char[] inputData = s.toCharArray();
        for (char c: inputData) {
            if (relation.keySet().contains(c)) {
                stack.push(c);
            } else if (relation.values().contains(c)){
                if (relation.getOrDefault(stack.peek(), '0') == c) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}