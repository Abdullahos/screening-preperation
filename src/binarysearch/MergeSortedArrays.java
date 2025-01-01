package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        Arrays.fill(nums1, m, n + m, Integer.MAX_VALUE);
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            list.add(num);
        }

        int idx;
        for (int num : nums2) {
            idx = Collections.binarySearch(list, num);
            if (idx > -1) {
                list.add(idx, num);
            }
            else {
                list.add(-idx - 1, num);
            }
        }

        for (int i = 0; i < n + m; i++) {
            nums1[i] = list.get(i);
        }
    }
}
