package BinarySearchTree;
import java.util.*;
public class TwoSuminBST {
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderOfBst(root,inorder);
        for(int i = 0;i<inorder.size();i++)
        {
            for(int j = i+1;j<inorder.size();j++)
            {
                if(inorder.get(i)+inorder.get(j)== k)  //if sum of any two nodes value in bst is equal to k then return true 
                {
                    return true;
                }
            }
        }
        return false;
    }
    public void inorderOfBst(TreeNode root,ArrayList<Integer> ino)
    {
        if(root == null)
        {
            return;
        }
        inorderOfBst(root.left,ino);
        ino.add(root.val);
        inorderOfBst(root.right,ino);

    }
}
