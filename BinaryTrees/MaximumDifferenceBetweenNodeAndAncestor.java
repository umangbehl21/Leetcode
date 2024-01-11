package BinaryTrees;

public class MaximumDifferenceBetweenNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root) { 
        int max = root.val; 
        int min = root.val;
        return maxAncestorDiffHelp(root,max,min); 
         
         
     }
     public int maxAncestorDiffHelp(TreeNode root,int max,int min) //finding the maximum and minimum node value from every root to leaf path and finding maximum difference between them maximum from all the paths is the answer 
     {
         if(root == null)
         {
             return Math.abs(max - min);
         }
         max = Math.max(max,root.val);
         min = Math.min(min,root.val);
        int lans = maxAncestorDiffHelp(root.left,max,min);
        int rans = maxAncestorDiffHelp(root.right,max,min);
        return Math.max(lans,rans);
     }
 
}
