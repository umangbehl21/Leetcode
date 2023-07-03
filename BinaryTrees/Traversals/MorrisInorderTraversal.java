package BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {
     public List<Integer> inorderTraversal(TreeNode root) {  //iterative moriss inorder traversal 
        List<Integer> ans = new ArrayList<>();
        while(root != null)
        {
            if(root.left == null)
            {
                ans.add(root.val);
                root = root.right; //if there is no left then there is no issue that we need to maintain any pointer to go to parent as if tree is skewed we add root and move to right
            }
            else
            {
                TreeNode prev = root.left;
                while(prev.right != null && prev.right != root) //prev.right != root because when we make a thread pointer from the last rightwards node to the parent then parent follow this pointer to reach its actual position when it reaches its actual position it again create a previous pointer to check if any dummy pointer or thread exist that point to the pointer so prev.right (!) should not equal to root or parent address if it is equal to root address or a thread exists then prev.right is set to null inorder to delete extra pointers 
                {
                    prev = prev.right;
                }
                if(prev.right == null)  //if there is no threaded pointer through which parent can move up to its actual position then make one from the last rightwards node to the parent node 
                {
                    prev.right = root;
                    root = root.left;
                }
                else 
                {
                    prev.right = null;  //when we enter this else this means previous is coming second time to this thread if it is coming second time root has already reached to the parent so delete this pointer or thread inorder to avoid infinite loop 
                    ans.add(root.val);
                    root = root.right;

                }
                


            }

        }
        return ans;
    }
}
