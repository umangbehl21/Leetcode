package BinaryTrees;

class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
        {
            return root;        
        }
        TreeNode lans = lowestCommonAncestor(root.left,p,q);
        TreeNode rans = lowestCommonAncestor(root.right,p,q);
        if(rans == null)
        {
            return lans;
        }
        else if(lans == null)
        {
            return rans;
        }
        else 
        {
            return root;
        }

    }
}
