package string;
import java.util.*;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        char[] tmp = s.toCharArray();
        int count = 0;
        int odd = 0;
        HashMap<Character, Integer> hash= new HashMap<>();
        for (char t:tmp){
            hash.put(t, hash.getOrDefault(t, 0)+1);
        }
        for (Map.Entry<Character, Integer> m: hash.entrySet()){
            if (m.getValue() % 2 == 0){
                count += m.getValue();
            } else {
                odd = 1;
                count += (m.getValue()-1);
            }
        }
        return count+odd;
    }
}
