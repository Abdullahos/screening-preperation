package tests.ibm.jul2024;


public class ClimbingStairs {

    private int climbingStairs(int flagHeight, int bigJump) {
        if (flagHeight < bigJump) {
            return flagHeight;
        }
        if (flagHeight == bigJump) {
            return 1;
        }

        int[] dp = new int[bigJump];

        for (int i = 0; i < bigJump; i++) {
            dp[i] = i + 1;
        }

        for (int i = bigJump; i < flagHeight; i++) {
            dp[(i % bigJump)] = Math.min(dp[(dp[i - 1] % bigJump)], dp[(i - bigJump) % bigJump]) + 1;
        }

        return dp[(flagHeight - 1) % bigJump];
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        climbingStairs.climbingStairs(3, 2);
    }

}
