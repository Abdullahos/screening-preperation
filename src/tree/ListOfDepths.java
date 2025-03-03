package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepths {

    List<LinkedList<Integer>> listOfDepthsOfTree;

    public ListOfDepths() {
        listOfDepthsOfTree = new ArrayList<>();
    }

    public void factor(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> depth = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                depth.add(queue.remove().val);
            }
            listOfDepthsOfTree.add(depth);
        }
    }

}
