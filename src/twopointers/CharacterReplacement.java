package twopointers;
//https://leetcode.com/problems/longest-repeating-character-replacement/

public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        int longest = 1;
        int[] freqs = new int[26];

        int mostFreq = 0;
        freqs[s.charAt(0) - 'A']++;
        int i = 0;

        for (int j = 1; j < s.length(); j++) {
            char c = s.charAt(j);
            freqs[c - 'A']++;
            mostFreq = Math.max(mostFreq, freqs[c - 'A']);

            while ((j - i + 1 - mostFreq) > k) {
                freqs[s.charAt(i++) - 'A']--;
            }

            longest = Math.max(longest, j - i + 1);
        }

        return longest;
    }

    public static void main(String[] args) {
        CharacterReplacement c = new CharacterReplacement();
        System.out.println(c.characterReplacement("ABAB", 2));
        System.out.println(c.characterReplacement("AABABBA", 1));
        System.out.println(c.characterReplacement("ABBB", 2));
        System.out.println(c.characterReplacement("AAAABA", 1));
        System.out.println(c.characterReplacement("AABABBABBBB", 1));
        System.out.println(c.characterReplacement("ABBBCCCCCCC", 2));
        System.out.println(c.characterReplacement("ABBAAAAACCCCCCC", 2));
        System.out.println(c.characterReplacement("A", 1));
    }
}
