package BinarySearchTree;

public class LargestBSTinBinarytree {
    static class BSTpair
    {
        int size;
        boolean isBST;
        int min;
        int max;
        BSTpair(boolean isBST,int size,int min,int max)
        {
            this.size = size;
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
    static BSTpair largestBST(TreeNode root)
    {
        if(root == null)
        {
            BSTpair bp = new BSTpair(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE); //on min integer.max_value is passed because minimum between an integer and max value is always integer on max Integer.MIN_VALUE is passed because maximum between an integer and min value is always integer 
            return bp;
        }

        BSTpair lp = largestBST(root.left);
        BSTpair rp = largestBST(root.right);
        
        boolean IsBST = lp.isBST && rp.isBST && (root.val > lp.max && root.val < rp.min); //for a node to check whether it is following bst property as a node or not it has to only check that it should be greater than maximum node value  from the left subtree and it should be lesser than the minimum node value from right subtree but for a node to check that it is following bst property as a Tree then its left subtree should also be a bst and its right should also be a bst 

        int min = Math.min(root.val,Math.min(lp.min,rp.min)); //child node maintain min,max both because if it is the left subtree of parent then parent need maximum from left subtree or if child is the right subtree of parent then parent need minimum from the right subtree so every child has to maintain both min and max because its parent may need it
        int max = Math.max(root.val,Math.max(lp.max,rp.max)); 

        BSTpair bp;
        if(IsBST)  //if isbst is true then we can add current node or parent node in the size of left subtree and right subtree
        {
            int totalsize = 1 + rp.size + lp.size;
            bp = new BSTpair(true,totalsize,min,max);
        }
        else  //if isbst is false means parent failed as a node to fulfill bst property so it will return maximum size of bst from its left subtree or right subtree
        {
            int maxsize = Math.max(lp.size,rp.size);
            bp = new BSTpair(false,maxsize,min,max);
        }

        return bp;
        
    }
    static int largestBst(TreeNode root)
    {
        BSTpair anspair = largestBST(root);
        return anspair.size; //return max size of bst in binary tree
        
    }
}
