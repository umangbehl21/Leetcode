package BinaryTrees;

class MaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int max[] = {Integer.MIN_VALUE};
        maxpathSumHelper(root,max);
        return max[0];
    }
    public int maxpathSumHelper(TreeNode root,int max[])  //remember kadanes algo we never take negative numbers in the current sum so this is the concept used if we get negative lsum and right sum we set them to 0 because negative values can never make maximum sum 
    {
        if(root == null)
        {
            return 0;
        }
        int lsum = Math.max(0,maxpathSumHelper(root.left,max));   // we are taking maximum between 0 and function call because negative values cannot help in computing maximum sum 
        int rsum = Math.max(0,maxpathSumHelper(root.right,max)); //by this if rsum is negative it will be set to 0 and only leftsum + root.cal is positive and they will take part to make sum maximum if both lsum and rsum is negative then both will be set to 0 and only root can give maximum sum (root.val + 0 + 0) 
        max[0] = Math.max(max[0],root.val + lsum + rsum);  //maximum is computed for every subtree example if tree is -3,-1,-2 max[0] will hold -1 and will not be update because right subtree sum is -2 and root also have data -3 
        return root.val + Math.max(lsum,rsum); //from root we can choose only one maximum path to go down that can originate from leftsubtree as well as rightsubtree whichever is maximum 

    }
}