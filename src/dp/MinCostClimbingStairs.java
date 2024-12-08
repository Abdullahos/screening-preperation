package dp;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public int minCostClimbingStairsBigJump(int[] cost, int bigJump) {
        int n = cost.length;
        int[] dp = new int[bigJump];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i % bigJump] = cost[i] + Math.min(dp[(i - 1) % bigJump], dp[(i - bigJump) % bigJump]);
        }
        return Math.min(dp[(n - 1) % bigJump], dp[(n - 2) % bigJump]);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs m = new MinCostClimbingStairs();
        int[] costs = {10, 15, 20};
        System.out.println(m.minCostClimbingStairs(costs));
        System.out.println(m.minCostClimbingStairsBigJump(costs, 2));

        System.out.println("-".repeat(100));

        System.out.println(m.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
        System.out.println(m.minCostClimbingStairsBigJump(new int[]{1,100,1,1,1,100,1,1,100,1}, 2));
    }
}
