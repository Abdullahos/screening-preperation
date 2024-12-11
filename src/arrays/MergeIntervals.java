package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> merged = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int a = intervals[0][0];
        int b = intervals[0][1];


        for (int i = 1; i < intervals.length; i++) {
            if (b >= intervals[i][0]) {
                b = Math.max(intervals[i][1], b);
            }
            else {
                merged.add(Arrays.asList(a,b));
                a = intervals[i][0];
                b = intervals[i][1];
            }
        }

        merged.add(Arrays.asList(a,b));

        int[][] result = new int[merged.size()][2];

        for (int i = 0; i < merged.size(); i++) {
            result[i][0] = merged.get(i).get(0);
            result[i][1] = merged.get(i).get(1);
        }

        return result;

    }
}
