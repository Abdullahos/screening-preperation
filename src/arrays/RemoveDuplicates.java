package arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int p = 0, c = 1, i = 1;

        for (i = 1; i < nums.length; i++) {
            while (c < nums.length && nums[p] == nums[c]) {
                c++;
            }
            if (c >= nums.length) {
                break;
            }
            nums[i] = nums[c];
            p = c;
            c++;
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4
}));
    }
}
