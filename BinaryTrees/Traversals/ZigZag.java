package BinaryTrees.Traversals;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> pendingnodes = new LinkedList<>();
        pendingnodes.add(root);
        boolean lefttoright = true;
        while (!pendingnodes.isEmpty()) {
            int size = pendingnodes.size();
            int arr[] = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = pendingnodes.remove();
                int index = (lefttoright) ? i : arr.length - 1 - i;
                arr[index] = node.val;
                if (node.left != null) {
                    pendingnodes.add(node.left);
                }
                if (node.right != null) {
                    pendingnodes.add(node.right);
                }
            }
            lefttoright = !lefttoright;
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                temp.add(arr[i]);
            }
            ans.add(temp);

        }
        return ans;

    }
}
