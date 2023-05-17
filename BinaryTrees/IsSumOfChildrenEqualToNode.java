package BinaryTrees;
class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}
public class IsSumOfChildrenEqualToNode {
    public static int isSumProperty(Node root)
    {
        if(root.left == null && root.right == null)
        {
            return 1;
        }
        // add your code here
        boolean equal [] = {true};
        int a = isSumPropertyHelp(root,equal);  //passing boolean array with one index because when we pass reference through array change is reflected everywhere where that array is being used if we pass an variable change will not be reflected to other function because java is pass by value
        if(!equal[0])
        {
            return 0;
        }
        else 
        {
            return 1;
        }
    }
    public static int isSumPropertyHelp(Node root,boolean equal[])
    {
        if(root == null)
        {
            return 0;
        }
        int lans = isSumPropertyHelp(root.left,equal);
        int rans = isSumPropertyHelp(root.right,equal);
        if(lans == 0 && rans == 0)
        {
            return root.data;
        }
        if(lans + rans != root.data)
        {
            equal[0] = false;
        }
        return root.data;
        
    }
}
