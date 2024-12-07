package twopointers;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k >= 26 || k >= s.length()) {
            return s.length();
        }
        int longest = 1;
        int distinct = 1;
        int[] freq = new int[26];

        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (freq[s.charAt(j) - 'a'] == 0) {
                distinct++;
                while (distinct > k && i <= j) {
                    freq[s.charAt(i) - 'a']--;
                    if (freq[s.charAt(i) - 'a'] == 0) {
                        distinct--;
                    }
                    i++;
                }
            }
            longest = Math.max(longest, j - i + 1);
            freq[s.charAt(j) - 'a']++;
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters obj = new LongestSubstringWithAtMostKDistinctCharacters();
        System.out.println(obj.lengthOfLongestSubstringKDistinct("abba", 2));
        System.out.println(obj.lengthOfLongestSubstringKDistinct("abbacccddef", 2));
        System.out.println(obj.lengthOfLongestSubstringKDistinct("abcdfeg", 7));
        System.out.println(obj.lengthOfLongestSubstringKDistinct("aabbccddeeffgg", 14));
        System.out.println(obj.lengthOfLongestSubstringKDistinct("aabbccddeeffggaabbccddeeffgg", 28));
        System.out.println(obj.lengthOfLongestSubstringKDistinct("abc", 4));
    }
}
