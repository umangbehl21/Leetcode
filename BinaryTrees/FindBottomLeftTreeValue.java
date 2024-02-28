package BinaryTrees;

class Solution {
    int ld = -1;
    int lrv = Integer.MIN_VALUE;
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValueHelper(root,0);
        return lrv;
    }
    public void findBottomLeftValueHelper(TreeNode root,int td)
    {
        if(root == null)
        {
            return;
        }
        if(td > ld)
        {
            lrv = root.val;
            ld = td;
        }
        findBottomLeftValueHelper(root.left,td + 1);
        findBottomLeftValueHelper(root.right,td + 1);
    }
}