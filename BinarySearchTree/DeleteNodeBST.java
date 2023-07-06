package BinarySearchTree;

public class DeleteNodeBST {
     public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
        {
            return null;
        }
        if(key < root.val)
        {
           root.left =  deleteNode(root.left,key);
           return root;
        }
        else if(key > root.val)
        {
           root.right = deleteNode(root.right,key);
           return root;
        }
        else 
        {
            if(root.left == null)
            {
                return root.right;
            }
            else if(root.right == null)
            {
                return root.left;
            }
            else{
              TreeNode maxnode = root.left;  
              while(maxnode.right != null) //maximmum from left subtree is the rightmost node whose data can be replaced with root.data
              {
                  maxnode = maxnode.right;
              }
              root.val = maxnode.val;
              root.left = deleteNode(root.left,maxnode.val); //delete the righmost node data which is now the root data 
              return root;
            
            }
        }
        
    }
}
