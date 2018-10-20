//poj 3280 chepeast palindrome
import java.util.HashMap;
import java.util.Scanner;
import java.util.*;

public class Chpalindrome {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().trim().split(" ");
        int charNum = Integer.parseInt(line[0]);
        int length = Integer.parseInt(line[1]);
        String string = sc.nextLine().trim();
        int[][] dp = new int[length][length];
        int[] minArray = new int[26];
        int count = 0;
        while(count < charNum){
            String[] tmp = sc.nextLine().trim().split(" ");
            char c = tmp[0].charAt(0);
            minArray[c-'a'] = Math.min(Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]));
            count ++;
        }
        for(int i = length-2;i >=0;i--){
            for(int j=i+1;j<length;j++){
                dp[i][j] = Math.min(dp[i+1][j] + minArray[string.charAt(i)-'a'],dp[i][j-1] + minArray[string.charAt(j)-'a']);
                if(string.charAt(i) == string.charAt(j)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
                }
            }
        }

        System.out.println(dp[0][length-1]);
    }

}
