package dp;

import java.util.Arrays;

public class JumpGame {

    public int minJumps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]);
        }
        return dp[n - 1];
    }

    public int minJumpsWithBigJumps(int[] arr, int bigJump) {
        int n = arr.length;
        int[] dp = new int[bigJump];
        Arrays.fill(dp, 1);
        for (int i = bigJump - 1; i < n; i++) {
            dp[i % bigJump] = Math.min(dp[(i - 1) % bigJump], dp[(i - bigJump) % bigJump]) + 1;
        }
        return dp[(arr.length - 1) % bigJump];
    }

}
