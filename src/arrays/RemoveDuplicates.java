package arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int idx, i = 0, j = 0;
        for (idx = 0; idx < nums.length; idx++) {
            if (j >= nums.length) {
                break;
            }
            while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                j++;
            }
            j++;
            nums[idx] = nums[i];
            if (j - i > 1) {
                nums[idx + 1] = nums[i];
                idx++;
            }
            i = j;
        }
        return idx;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
