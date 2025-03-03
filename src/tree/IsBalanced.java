package tree;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return isBalancedRec(root) != -1;
    }

    private int isBalancedRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = isBalancedRec(root.left);
        if (l == -1) {
            return -1;
        }
        int r = isBalancedRec(root.right);
        if (r == -1) {
            return -1;
        }
        if (Math.abs(l - r) > 1) {
            return -1;
        }
        return 1 + Math.max(r, l);
    }

}
