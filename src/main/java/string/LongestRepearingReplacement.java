package string;

public class LongestRepearingReplacement {
    public int characterReplacement(String s, int k) {
        if (s.length() == 0) {
            return 0;
        }
        int max_number = 1;
        int curr_number = 1;
        for (int i=0; i< s.length(); ++i) {
            int j = i+1;
            int tolerant = k;
            while (j < s.length() && (s.charAt(j) == s.charAt(i) || tolerant > 0)){
                if (s.charAt(i) != s.charAt(j)) {
                    tolerant --;
                }
                curr_number ++;
                j ++;
            }
            if (curr_number + tolerant >= s.length()){
                curr_number = s.length();
            } else {
                curr_number = curr_number+tolerant;
            }
            max_number = Math.max(max_number, curr_number);
            curr_number = 1;
        }
        return max_number;
    }
}
