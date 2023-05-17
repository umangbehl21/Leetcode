package BinaryTrees.Traversals;
import java.util.*;
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> ans = new ArrayList<>();
      leftviewhelp(root,ans,0);
      return ans;
    }
    void leftviewhelp(Node root,ArrayList<Integer> ans,int level) 
    {
        if(root == null)
        {
            return;
        } 
        if(level == ans.size())  
        {
            ans.add(root.data);
        }
        leftviewhelp(root.left,ans,level+1);
        leftviewhelp(root.right,ans,level+1);
    }
    
}