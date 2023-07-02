package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDesirialize {
    
    public String serialize(TreeNode root) {
       if(root == null)
       {
           return " ";
       }
       String s = "";
       Queue<TreeNode> q = new LinkedList<>();
       q.add(root);
       s += root.val + " ";
       while(!q.isEmpty())
       {
           TreeNode front = q.remove();
           if(front.left == null)
           {
               s += "n ";
           }
           else 
           {
               s += front.left.val + " ";
               q.add(front.left);   
           }
           if(front.right == null)
           {
              s += "n " ;
           }
           else
           {
               s+= front.right.val + " ";
               q.add(front.right);
           }

       }
       return s;

    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == " ")
        {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        String values[] = data.split(" ");  //returns array of subtrings in which at each index there is single character string seperated by the " " seperator
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for(int i = 1;i<values.length;i++) //start traversing string array from 1 index where left child will be present
        {
            TreeNode parent = q.remove();
            if(!values[i].equals("n"))  //if left data of parent node is not null then make a node attach it to parent and add that node into the queue as it may also have child node attach to it 
            {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            } 
            if(!values[++i].equals("n")) //we do ++i because currently i is on left child to make it come upon right child , if right data of parent node is not null then make a node attach it to parent and add that node into the queue as it may also have child node attach to it 
            {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }


        }
        return root;
    }


}
