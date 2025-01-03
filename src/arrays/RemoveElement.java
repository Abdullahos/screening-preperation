package arrays;

public class RemoveElement {
    //Space O(1), time O(n)
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == val) {
                j++;
                continue;
            }
            nums[i] = nums[j];
            j++;
            i++;
        }
        return i;
    }

}
