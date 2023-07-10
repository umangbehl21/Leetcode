package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoBst {
     public List<Integer> merge(TreeNode root1,TreeNode root2)
    {
        ArrayList<Integer> inone = new ArrayList<>();
        ArrayList<Integer> intwo = new ArrayList<>();
        inorderOfRoot1(root1,inone);  //1st step -> //making inorder of first binary search tree and storing in arraylist
        inorderOfRoot2(root2,intwo);  //making inorder of second binary search tree and storing in arraylist
        int ans[] = new int[inone.size() + intwo.size()];
        int c1 = 0;
        int c2 = 0;
        int i = 0;
        while(c1 < inone.size() && c2 < intwo.size())  //2nd step -> // then concept of merge two sorted arrays are applied on two inorder arrays of two trees 
        {
           if(inone.get(c1) < intwo.get(c2))
           {
               ans[i] = inone.get(c1);
               c1++;
           }
           else 
           {
               ans[i] = intwo.get(c2);
               c2++;
           }
           i++;
        }
        while(c1 < inone.size())
        {
            ans[i] = inone.get(c1);
            c1++;
            i++;
        }
        while(c2 < intwo.size())
        {
            ans[i] = intwo.get(c2);
            c2++;
            i++;
        }
        List<Integer> list = new ArrayList<>();
        for(int j = 0;j<ans.length;j++)  
        {
            list.add(j,ans[j]);
        }
        return list;  //now that we get list containing inorder of two merged bst we can make a balanced tree from inorder 
        
    }
    public void inorderOfRoot1(TreeNode root1,ArrayList<Integer> inone)
    {                        
        if(root1 == null)
        {
            return;
        }
        inorderOfRoot1(root1.left,inone);
        inone.add(root1.val);
        inorderOfRoot1(root1.right,inone);
        
    }
    public void inorderOfRoot2(TreeNode root2,ArrayList<Integer> intwo)
    {
        if(root2 == null)
        {
            return;
        }
        inorderOfRoot2(root2.left,intwo);
        intwo.add(root2.val);
        inorderOfRoot2(root2.right,intwo);
    }
    public TreeNode MakeBstFromInorder(int inorder[],int start,int end) //3rd step //this is how we can make a balanced bst from inorder as inorder of BST is always sorted in ascending order we can consider middle of inorder as the root and its left as left subtree and right as right subtree
    {
        if(start > end)
        {
            return null;
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(inorder[mid]);
        root.left = MakeBstFromInorder(inorder,start,mid - 1);
        root.right = MakeBstFromInorder(inorder, mid + 1, end);
        return root;
    }
}

