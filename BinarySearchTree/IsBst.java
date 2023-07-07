package BinarySearchTree;

public class IsBst {
     public boolean isValidBST(TreeNode root) {
        long start = Long.MIN_VALUE;
        long end = Long.MAX_VALUE;
        return isValidBSThelper(root,start,end);
    }
   public boolean isValidBSThelper(TreeNode root,long start,long end )
    {
        if(root == null)
        {
            return true;
        }
        if(root.val >= end || root.val <= start)
        {
            return false;
        }
       
        Boolean lans = isValidBSThelper(root.left,start,root.val);
        Boolean rans = isValidBSThelper(root.right,root.val,end);
        return lans && rans;

    }
}
