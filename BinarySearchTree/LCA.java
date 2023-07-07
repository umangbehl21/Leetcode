package BinarySearchTree;

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) { //if p and q both are on left then no need to call for right subtree same goes if p and q on right 
            TreeNode lans = lowestCommonAncestor(root.left, p, q);
            return lans;
        }
         else if (p.val > root.val && q.val > root.val) {
            TreeNode rans = lowestCommonAncestor(root.right, p, q);
            return rans;
        } 
        else { //if p and q are on left and right subtree then both call is necessary 
            TreeNode lans = lowestCommonAncestor(root.left, p, q);
            TreeNode rans = lowestCommonAncestor(root.right, p, q);

            if (rans == null) {  //if rans is null we return lans this lans can also be null or some root 
                return lans;
            } 
            else if (lans == null) { //if lans is null we return rans this rans can also be null or some root
                return rans;
            }
             else {
                return root; //root is return when from both side p and q is being returned so root become the ancestor 
            }
        }

    }
}
