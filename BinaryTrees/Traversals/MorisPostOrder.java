package BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.Collections;

public class MorisPostOrder {
     ArrayList<Integer> postOrder(Node node) {  //in postorder we go towards right subtree and add its rightward nodes first, right nodes are added before left and root is added before right and left because in the end arraylist is reversed example if tree is 1,2L,3R then 1 will be added first then we move to right 3 will be added then at last 2 will be added (1,3,2) now reverse this list to make postorder
        ArrayList<Integer> ans = new ArrayList<>();
        while(node != null)
        {
          if(node.right == null) //in postorder we go towards right subtree and add its rightward nodes first, right nodes are added before left so going right is our first priority but if there is no right then only we go left
          {
              ans.add(node.data);
              node = node.left;
          }
          else 
          {
              Node dumy = node.right;
              while(dumy.left != null && dumy.left != node) //leftmost node of right subtree 
              {
                 dumy = dumy.left;
              }
              if(dumy.left == null)
              {
                  ans.add(node.data);
                  dumy.left = node;
                  node = node.right;
                  
              }
              else 
              {
                  dumy.left = null;
                  node = node.left;
              }
              
          }
            
        }
        Collections.reverse(ans);
        return ans;
}
}
