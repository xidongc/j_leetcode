package hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class UncommonWords {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> rel = new HashMap<>();
        String[] str1 = A.split(" ");
        String[] str2 = B.split(" ");
        String[] result = new String[str1.length+str2.length];
        System.arraycopy(str1, 0, result, 0, str1.length);
        System.arraycopy(str2, 0, result, str1.length, str2.length);
        ArrayList<String> ans = new ArrayList<>();
        for (String r :result) {
            int val = rel.computeIfAbsent(r, k->{
                ans.add(r);
                return 0;
            }) + 1;
            rel.put(r,val);
            if (ans.contains(r) && val >= 2) {
                ans.remove(r);
            }
        }
        String[] ans_str = new String[ans.size()];
        ans_str = ans.toArray(ans_str);
        return ans_str;
    }
}
