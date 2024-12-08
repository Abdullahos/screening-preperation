package dp;

//https://leetcode.com/problems/jump-game-iii/

public class JumpGame3 {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return canReachRec(arr, start, visited);
    }

    private boolean canReachRec(int[] arr, int i, boolean[] visited) {
        if (i >= arr.length || i < 0 || visited[i]) {
            return false;
        }
        if (arr[i] == 0) {
            return true;
        }
        visited[i] = true;
        return canReachRec(arr, i + arr[i], visited) || canReachRec(arr, i - arr[i], visited);
    }
}
