package BinarySearchTree;

class BSTPredecessorAndSuccessor {
    static TreeNode pre = null;
    static TreeNode suc = null;

    public static void findPreSuc(TreeNode root, int key) {
        if (root == null) {
            return;
        }
        if (root.val == key) { //if key is at the root then 

            // The maximum value in left subtree is immediate predecessor
            if (root.left != null) {
                TreeNode tmp = root.left;
                while (tmp.right != null)
                    tmp = tmp.right;

                pre = tmp;
            }

            // The minimum value in right subtree is immediate successor 
            if (root.right != null) {
                TreeNode tmp = root.right;

                while (tmp.left != null)
                    tmp = tmp.left;

                suc = tmp;
            }
            return;
        }
        if (root.val < key) { //if key is greater than root.val then then root can be predecessor but if there are right nodes to root which are smaller than key then they can  be predecessor so move right 
            pre = root;
            findPreSuc(root.right, key);
        } else { //if key is less than root.val then it can be successor but if root have left nodes then its immediate successor is in left 
            suc = root;
            findPreSuc(root.left, key);
        }

    }

}
