package BinaryTrees.Traversals;

import java.util.ArrayList;

public class MorisPreorder {
    ArrayList<Integer> preOrder(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        while(root != null)
        {
            if(root.left == null)
            {
                ans.add(root.data);
                root = root.right;
            }
            else 
            {
                Node dumy = root.left;
                while(dumy.right != null && dumy.right != root)
                {
                    dumy = dumy.right;
                }
                if(dumy.right == null)
                {
                    ans.add(root.data); //root is added first in preorder afterwards left and right added so when we make dumy pointer to root then add root in list and then take root to left node 
                    dumy.right = root;   
                    root = root.left;
                }
                else 
                {
                    dumy.right = null;
                    root = root.right;
                    
                }
                
                
            }
            
        }
        return ans;
        
    }
    
}
