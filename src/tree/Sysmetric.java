package tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Sysmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null || root.right == null) {
            return root.left == root.right;
        }
        return isSymmetricRec(root.left, root.right);
    }

    public boolean isSymmetricIterative(TreeNode root) {
        if (root.left == null || root.right == null) {
            return root.left == root.right;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        while (!list.isEmpty()) {
            for (int i = 0; i < list.size() / 2; i++) {
                TreeNode l = list.get(i);
                TreeNode r = list.get(list.size() - i - 1);

                if (l == null || r == null) {
                    if (l != r) {
                        return false;
                    }
                }

                else if (l.val != r.val) {
                    return false;
                }
            }

            List<TreeNode> newList = new ArrayList<>(list.size());
            for (TreeNode node : list) {
                if (node != null) {
                    newList.add(node.left);
                    newList.add(node.right);
                }
            }
            list = newList;
        }

        return true;
    }
    private boolean isSymmetricRec(TreeNode l, TreeNode r) {
        if (l == null || r == null) {
            return l == r;
        }
        if (l.val != r.val) {
            return false;
        }
        return isSymmetricRec(l.left, r.right) && isSymmetricRec(l.right, r.left);
    }
}
