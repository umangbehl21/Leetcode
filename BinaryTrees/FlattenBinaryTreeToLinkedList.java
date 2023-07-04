package BinaryTrees;

public class FlattenBinaryTreeToLinkedList {
     public void flatten(TreeNode root) {
       while(root != null)
       {
           if(root.left != null)
           {
               TreeNode dumy = root.left;
               while(dumy.right != null)  //left subtree right most node its pointer points to the right subtree node 
               {
                   dumy = dumy.right;
               }
               dumy.right = root.right; 
               root.right = root.left; //as leftmost node of left subtree points to right subtree node root or parent node can now replace its right pointer and point to the left subtree which left pointer was pointing 
               root.left = null; //as linked list have only one pointer so set left pointer to null as we are maintaining right pointer
           }
           root = root.right;
       }
    
    }
}
