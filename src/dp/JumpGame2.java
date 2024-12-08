package dp;

import java.util.Arrays;
//Top Down Recursive approach
//https://leetcode.com/problems/jump-game-ii/submissions

public class JumpGame2 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return jumpRec(nums, dp, 0);
    }

    private int jumpRec(int[] nums, int[] dp, int start) {
        if (start >= nums.length - 1) {
            return 0;
        }
        if (dp[start] != Integer.MAX_VALUE) {
            return dp[start];
        }
        for (int step = nums[start]; step > 0; step--) {
            int steps = jumpRec(nums, dp, start + step);
            if (steps != Integer.MAX_VALUE) {
                dp[start] = Math.min(dp[start], steps + 1);
            }
        }
        return dp[start];
    }
}
