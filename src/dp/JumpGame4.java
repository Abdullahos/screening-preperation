package dp;

//cause time limit, u can use sliding window approach
//public boolean canReach(String s, int minJump, int maxJump) {
//    if (s.charAt(s.length() - 1) == '1') {
//        return false;
//    }
//
//    boolean[] dp = new boolean[s.length()];
//    dp[0] = true; // Start at index 0
//    int reachable = 0; // Tracks the leftmost reachable index
//
//    for (int i = 1; i < s.length(); i++) {
//        if (i >= minJump) {
//            reachable += dp[i - minJump] ? 1 : 0; // Include the index that's now reachable
//        }
//        if (i > maxJump) {
//            reachable -= dp[i - maxJump - 1] ? 1 : 0; // Exclude the index that's no longer reachable
//        }
//        dp[i] = s.charAt(i) == '0' && reachable > 0;
//    }
//
//    return dp[s.length() - 1];
//}

public class JumpGame4 {
    public boolean canReach(String s, int minJump, int maxJump) {
        Boolean[] dp = new Boolean[s.length()];
        if (s.charAt(s.length() - 1) == '1') {
            return false;
        }
        return canReachRec(s, minJump, maxJump, 0, dp);
    }


    private boolean canReachRec(String s, int minJump, int maxJump, int start, Boolean[] dp) {
        if (start >= s.length() || s.charAt(start) != '0') {
            return false;
        }
        if (start == s.length() - 1) {
            return true;
        }
        if (dp[start] != null) {
            return dp[start];
        }
        for (int i = start + minJump; i < Math.min(start + maxJump + 1, s.length()); i++) {
            boolean can = canReachRec(s, minJump, maxJump, i, dp);
            if (can) {
                dp[i] = true;
                return true;
            }
            dp[i] = false;
        }
        dp[start] = false;
        return false;
    }

    public static void main(String[] args) {
        JumpGame4 jumpGame4 = new JumpGame4();
        System.out.println(jumpGame4.canReach("01101110", 2, 3));
    }
}
