package BinarySearchTree;

import java.util.Arrays;

public class ConstructBSTfromPreorder {
      public TreeNode bstFromPreorder(int[] preorder) {
       int[] inorder = new int[preorder.length];
       for(int i = 0;i<inorder.length;i++)
       {
           inorder[i] = preorder[i];
       }
       Arrays.sort(inorder);
       return ConstructFromInPre(preorder,inorder,0,inorder.length - 1,0,preorder.length - 1);
    }
    public TreeNode ConstructFromInPre(int[]preorder,int[]inorder,int inS,int inE,int prS,int prE)
    {   
        if(inS > inE)
        {
            return null;
        }
       int rootdata = preorder[prS];
       TreeNode root = new TreeNode(rootdata);
       int rootidx = -1;
       for(int i = 0;i<=inorder.length;i++)
       {
           if(inorder[i] == rootdata)
           {
               rootidx = i;
               break;
           } 
       }
       int linS = inS;
       int linE = rootidx - 1;
       int lprS = prS + 1;
       int lprE = linE - linS + lprS;
       int rinS = rootidx + 1;
       int rinE = inE;
       int rprS = lprE + 1;
       int rprE = prE;
       root.left = ConstructFromInPre(preorder,inorder,linS,linE,lprS,lprE);
       root.right = ConstructFromInPre(preorder,inorder,rinS,rinE,rprS,rprE);
       return root;

    }
}
