package tree;


public class MinimalTree {

    TreeNode root;

    public MinimalTree(int[] sortedArrAsc) {
        this.root = getMinNode(sortedArrAsc, 0, sortedArrAsc.length - 1);
        minimalTreeRec(sortedArrAsc, root, 0, sortedArrAsc.length - 1);
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public void minimalTreeRec(int[] sortedArrAsc, TreeNode mid, int start, int end) {
        if (mid == null) {
            return;
        }
        int midIdx = start + (end - start) / 2;
        mid.left = getMinNode(sortedArrAsc, start, midIdx - 1);
        mid.right = getMinNode(sortedArrAsc, midIdx + 1, end);
        minimalTreeRec(sortedArrAsc, mid.left, start, midIdx - 1);
        minimalTreeRec(sortedArrAsc, mid.right, midIdx + 1, end);

    }

    private TreeNode getMinNode(int[] sortedArrAsc, int start, int end) {
        if (start >= end) {
            return null;
        }
        int midElement = sortedArrAsc[(end + start) / 2];
        return new TreeNode(midElement);
    }

}
