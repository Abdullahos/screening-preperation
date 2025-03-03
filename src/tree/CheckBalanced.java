package tree;

public class CheckBalanced {

    public int dfs(TreeNode root) throws Exception {
        if (root == null) return 0;

        int leftDepth = 1 + dfs(root.left);
        int rightDepth = 1 + dfs(root.right);

        if (Math.abs(leftDepth - rightDepth) > 1) {
            throw new Exception("Unbalanced Tree");
        }

        return Math.max(leftDepth, rightDepth);
    }

}
