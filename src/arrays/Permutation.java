package arrays;

//if same characters no more no less
public class Permutation {

    private boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] freq = new int[128]; //assume it's ascii
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int f = freq[s2.charAt(i)]--;
            if (f < 0) {
                return false;
            }
        }

        return true;
    }

}
