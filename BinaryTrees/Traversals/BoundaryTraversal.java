package BinaryTrees.Traversals;
import java.util.*;
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
class Solution
{
	ArrayList<Integer> boundary(Node node)
	{
	 ArrayList<Integer> ans = new ArrayList<Integer>();
	 ans.add(node.data);
	 if(node.left == null && node.right == null)
	 {
	     return ans;
	 }
     
     LeftBoundary(node.left, ans);
     LeafNodes(node, ans);
     RightBoundary(node.right, ans);
     return ans;
          
	}
	 public void LeftBoundary(Node root,ArrayList<Integer> ans)
     {
         if(root == null || (root.left == null && root.right == null))  //if called root is null or a leaf node return because leafs are added at tree traversal
         {
             return;
         }
         ans.add(root.data);  
         if(root.left != null)
         {
             LeftBoundary(root.left,ans);
         }
         else 
         {
             LeftBoundary(root.right,ans);
         }
         

     }
     public void LeafNodes(Node root,ArrayList<Integer> res)
     {
        if(root == null)
        {
            return;
        }
        if(root.left == null && root.right == null)
        {
        res.add(root.data);
        }
        LeafNodes(root.left, res);
        LeafNodes(root.right, res);
     }
     public void RightBoundary(Node root,ArrayList<Integer> res)
     {
        if(root == null || (root.left == null && root.right == null))
        {
            return;
        }
        if(root.right != null)
        {
            RightBoundary(root.right,res);
        }
        else 
        {
            RightBoundary(root.left,res);
        }
        res.add(root.data);  //add while backtracking because we need end nodes data first in the ArrayList
        
     }

	
}

