package arrays;

public class ConstructStringWithRepeatLimit {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freqs = new int[26];
        for (char c : s.toCharArray()) {
            freqs[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        while (true) {
            char c = findNext(freqs, 25);
            if (c == '.') {
                break;
            }

            int charIndex = c - 'a';
            int count = Math.min(freqs[charIndex], repeatLimit);

            sb.append(String.valueOf(c).repeat(count));
            freqs[charIndex] -= count;

            if (freqs[charIndex] > 0) {
                char next = findNext(freqs, charIndex - 1);
                if (next == '.') {
                    break;
                }
                sb.append(next);
                freqs[next - 'a']--;
            }
        }

        return sb.toString();
    }

    private char findNext(int[] freqs, int startSearchFrom) {
        for (int i = startSearchFrom; i >= 0; i--) {
            if (freqs[i] > 0) {
                return (char) ('a' + i);
            }
        }
        return '.';
    }

    public static void main(String[] args) {
        ConstructStringWithRepeatLimit cs = new ConstructStringWithRepeatLimit();
        System.out.println(cs.repeatLimitedString("cczazcc", 3));
    }
}
