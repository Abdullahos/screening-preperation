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

    //with cost array
    public int minJumpsWithBigJumps(int[] cost, int bigJump) {
        int n = cost.length;

        int[] dp = new int[bigJump];

        dp[0] = cost[0];    //if u can start from 0 and
        dp[1] = cost[1];    //an start from 1

        for (int i = 2; i < bigJump; i++) {
            dp[i] = cost[i] + dp[i - 1];
        }

        for (int i = bigJump; i < n; i++) {
            int rollingIdx = (i) % bigJump;
            int prevIdx = (i - 1) % bigJump;
            int prevBigJump = (i - bigJump) % bigJump;

            dp[rollingIdx] = cost[i] + Math.min(dp[prevIdx], dp[prevBigJump]);
        }

        //because u can't start from 0 or 1
        Arrays.sort(dp);

        return dp[0];
    }

    //initially at 0 step and need to reach n
    public int ibm(int n, int bigJump) {
        int[] dp = new int[bigJump];
        Arrays.fill(dp, 1);
        for (int i = bigJump; i <= n; i++) {
            dp[i % bigJump] = Math.min(dp[(i - 1) % bigJump], dp[(i - bigJump) % bigJump]) + 1;
        }
        return dp[n % bigJump];
    }


    //without cost array
    public int min(int n, int bigJump) {
        if (n <= bigJump) {
            return 1;
        }

        int[] dp = new int[bigJump];
        Arrays.fill(dp, 1, bigJump, 1);

        for (int i = bigJump; i < n; i++) {
            dp[i % bigJump] = Math.min(dp[(i - 1) % bigJump], dp[(i - bigJump) % bigJump]) + 1;
        }
        return dp[(n - 1) % bigJump];
    }

}
