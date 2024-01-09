import java.util.ArrayList;

import BinarySearchTree.TreeNode;

class Solution {
    ArrayList<Integer> left = new ArrayList<>();
    ArrayList<Integer> right = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        leftleafsimilar(root1);
        rightleafsimilar(root2);
        if(left.size() != right.size())
        {
            return false;
        }
        else 
        {
            for(int i = 0;i<left.size();i++)
            {
                if(left.get(i) != right.get(i))
                {
                    return false;
                }
            }
            return true;
        }
    }
    public void leftleafsimilar(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        leftleafsimilar(root.left);
        leftleafsimilar(root.right);
        if(root.left == null & root.right == null)
        {
            left.add(root.val);
        }
    }
    public void rightleafsimilar(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        rightleafsimilar(root.left);
        rightleafsimilar(root.right);
        if(root.left == null & root.right == null)
        {
            right.add(root.val);
        }
    }

}