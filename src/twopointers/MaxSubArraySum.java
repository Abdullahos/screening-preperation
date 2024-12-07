package twopointers;

import java.util.HashSet;
import java.util.Set;

public class MaxSubArraySum {

    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, sum = 0;
        int i = 0;

        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < nums.length; j++) {
            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            set.add(nums[j]);
            sum += nums[j];

            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubArraySum m = new MaxSubArraySum();
        System.out.println(m.maximumSubarraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 2));
        System.out.println(m.maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
        System.out.println(m.maximumSubarraySum(new int[]{4, 4, 4}, 3));
        System.out.println(m.maximumSubarraySum(new int[]{4, 4, 4}, 2));
        System.out.println(m.maximumSubarraySum(new int[]{4, 4, 4}, 1));
        System.out.println(m.maximumSubarraySum(new int[]{4, 4, 4}, 0));
        System.out.println(m.maximumSubarraySum(new int[]{4}, 1));
        System.out.println(m.maximumSubarraySum(new int[]{4, 4, 4}, 1));
        System.out.println(m.maximumSubarraySum(new int[]{4}, 2));

    }
}
