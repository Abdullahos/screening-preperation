package arrays;

import java.util.ArrayList;
import java.util.List;

public class MostVisitedSector {
    int mostFreq = 0;
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] freqs = new int[n];
        int i = 0;
        int j = 1;

        while (i <= j && j < rounds.length) {
            incFreq(i++, j++, freqs, rounds, n);
        }

        if (rounds.length % 2 != 0) {
            freqs[rounds[i]]++;
        }

        List<Integer> res = new ArrayList<>();
        for (int sector = 1; sector < freqs.length; sector++) {
            int f = freqs[sector];
            if (f == mostFreq) {
                res.add(sector);
            }
        }

        return res;

    }

    private void incFreq(int i, int j, int[] freqs, int[] rounds, int n) {
        if (i > j) {
            while (i <= n) {
                freqs[rounds[i]]++;
                mostFreq = Math.max(freqs[i], mostFreq);
                i++;
            }

            i = 1;
            while (i <= j) {
                freqs[rounds[i]]++;
                mostFreq = Math.max(freqs[i], mostFreq);
                i++;
            }
        }
        else {
            while (i <= j) {
                freqs[rounds[i]]++;
                mostFreq = Math.max(freqs[rounds[i]], mostFreq);
                i++;
            }
        }
    }

    public static void main(String[] args) {
        MostVisitedSector sector = new MostVisitedSector();
        System.out.println(sector.mostVisited(4, new int[]{1,3,1,2}));
    }
}
