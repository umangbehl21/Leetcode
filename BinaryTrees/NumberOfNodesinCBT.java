package BinaryTrees;
 import java.util.*;
class NumberOfNodesinCBT { //there are always some subtrees in a large CBT on which formula can be applied which saves time
    public int countNodes(TreeNode root) {  //first we compute height of left and right subtree as we can directly apply formula if not equal we do the same for subtrees by computing height and checking if formulae can be applied 
        if(root == null)
        {
            return 0;
        }
        int lh = leftheight(root);
        int rh = rightheight(root);
        if(lh == rh) //left height and right height is only equal when all the levels in the subtree is fully completed with the nodes even last level is full then only this formula can be applied it will happen for some subtrees whose all levels are filled 
        {
       return (int)Math.pow(2,lh+1) - 1; // +1 is done for including the root node while computing the total nodes, as when there is only one node in subtree lh and rh will be 0 now if we dont do + 1 and do 2 ^ 0 - 1 it will be 1-1 = 0 but height of a single node is 1 in terms of nodes so we do 2^(h+1) - 1
        }
        else  //if left height and right height is not same then we give opportunity to the subtree to check their heights and if their lh and rh is equal they can use the formula if not equal they give opportunity to their child subtree and then for a single node always have lh and rh equal as lh and rh for single node is 0 then 2 ^ (0+1) -1 
        {
            return countNodes(root.left) + countNodes(root.right) + 1;   
        }

    }
    public int leftheight(TreeNode root)
    {
        int count = 0;
        while(root.left != null)
        {
           count++;
           root = root.left;
        }
        return count;
    }
     public int rightheight(TreeNode root)
    {
        int count = 0;
        while(root.right != null)
        {
           count++;
           root = root.right;
        }
        return count;
    }
}