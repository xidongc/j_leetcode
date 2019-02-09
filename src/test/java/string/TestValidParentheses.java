package string;

import java.util.*;
import java.util.stream.Collectors;

public class TestValidParentheses {

    public static void testLongestPalindrome(String s) {
        String[] result = s.trim().replaceAll("[^A-Za-z]", " ").toLowerCase().split(" ");
        String a = Arrays.stream(result).filter(k->!k.equals("")).collect(Collectors.joining("->", "[", "]"));
        System.out.println(a);
    }

    public static void main(String[] args) {
        testLongestPalindrome("（I am Jack and my father is Jimmy. I like wearing Jack and Jone's. ）");
    }
}
