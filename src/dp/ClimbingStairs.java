package dp;

//https://leetcode.com/problems/climbing-stairs/submissions/1470749304/

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }

    public int climbStairs2(int n) {
        if (n <= 1) return n;

        int[] dp = new int[2];

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i % 2] = dp[(i  - 1) % 2] + dp[(i - 2) % 2];
        }

        return dp[(n + 1) % 2];
    }
}
