package slidingwindow;

public class A_MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0, sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                min = Math.min(min, j - i + 1);
                sum -= nums[i++];
            }
            j++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        A_MinSubArrayLen minSubArrayLen = new A_MinSubArrayLen();
        System.out.println(minSubArrayLen.minSubArrayLen(3, new int[]{1, 3, -1, -3}));
        System.out.println(minSubArrayLen.minSubArrayLen(3, new int[]{-3}));
        System.out.println(minSubArrayLen.minSubArrayLen(7, new int[]{-2,3,1,2,4,3}));
        System.out.println(minSubArrayLen.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }
}
