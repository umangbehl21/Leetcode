package BinaryTrees;

public class CheckIfTreeIsIdentical {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null)
        {
            return p == q; //if p is null and q is not then due to == operator it will return false if both are null it will return true
        }
        if(p.val != q.val)
        {
            return false;
        }
        boolean lans = isSameTree(p.left,q.left);
        boolean rans = isSameTree(p.right,q.right);
        return lans && rans;
    }
}
