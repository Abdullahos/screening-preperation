package twopointers;

import java.util.HashMap;
import java.util.Map;

public class C_LengthOfTheLongestSubstringWithNoConsecutiveSameLetters {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        while (j < n) {
            Integer idx = map.get(s.charAt(j));
            if (idx != null && idx >= i){
                maxLength = Math.max(maxLength, j - i);
                i = idx + 1;
            }
            map.put(s.charAt(j), j);
            j++;
        }
        return Math.max(maxLength, j - i);
    }

    public static void main(String[] args) {
        C_LengthOfTheLongestSubstringWithNoConsecutiveSameLetters l = new C_LengthOfTheLongestSubstringWithNoConsecutiveSameLetters();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));

        System.out.println(l.lengthOfLongestSubstring("abcdefg"));

        System.out.println(l.lengthOfLongestSubstring("aaaaaaaa"));

        System.out.println(l.lengthOfLongestSubstring("babcabcbb"));

        System.out.println(l.lengthOfLongestSubstring("babcabcbbabcdefghijklmnopqrstuvwxyz"));

        System.out.println(l.lengthOfLongestSubstring("a"));

        System.out.println(l.lengthOfLongestSubstring("ac"));

        System.out.println(l.lengthOfLongestSubstring("abc"));

        System.out.println(l.lengthOfLongestSubstring(""));





    }
}
