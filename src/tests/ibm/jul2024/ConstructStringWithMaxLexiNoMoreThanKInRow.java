package tests.ibm.jul2024;

public class ConstructStringWithMaxLexiNoMoreThanKInRow {

    private String construct(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int lastBigIndex = 25;
        StringBuilder sb = new StringBuilder();

        while (true) {
            int idx = getIdx(freq, lastBigIndex);
            if (idx == -1) {
                break;
            }
            char c = (char) ('a' + idx);
            int repeatFor = Math.min(freq[idx], k);
            sb.append(String.valueOf(c).repeat(repeatFor));
            freq[idx] -= repeatFor;

            if (freq[idx] == 0) {
                lastBigIndex = idx - 1;
            }
            else {
                int nextIdx = getIdx(freq, idx - 1);
                if (nextIdx == -1) {
                    break;
                }
                char nextChar = (char) ('a' + nextIdx);
                sb.append(nextChar);
                freq[nextIdx]--;
            }
        }
        return sb.toString();

    }

    private int getIdx(int[] freq, int lastBigIndex) {
        for (int i = lastBigIndex; i >= 0; i--) {
            if (freq[i] > 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ConstructStringWithMaxLexiNoMoreThanKInRow construct = new ConstructStringWithMaxLexiNoMoreThanKInRow();
        System.out.println(construct.construct("babccc", 2));
        System.out.println(construct.construct("babcccccccccc", 2));
    }

}
