package BinaryTrees;
public class BuildTreeFromPreAndIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildtreehelper(preorder,inorder,0,inorder.length-1,0,preorder.length-1);
     }
     public TreeNode buildtreehelper(int pre[],int in[],int ins,int ine,int prs,int preE)
     {
         if(ins > ine)  //when a single node become a root then the ins and ine both are of same root index lets say 0 and when recursion further compute inorder end it do rootindex - 1 which will be 0-1 = -1 the end is less than start then there will be no node present so attach null to root 
         {              //for the right subtree while doing rins = rootindex + 1 when there will be a single node then both ins and ine will be at same root index lets say 7 and when recursion further compute inorder start it will do rootindex + 1 that is 7 + 1 = 8 and inorder end is 7 so start will be greater than end there is no such data of which node can be made so attach null to root 
             return null;
         }
 
         int rootdata = pre[prs];
         TreeNode root = new TreeNode(rootdata);
         int rootidx = -1;
         for(int i = 0;i<=ine;i++)
         {
             if(in[i] == rootdata)
             {
                 rootidx = i;
                 break;
             }
         }
         int lins = ins;  //left inorder start
         int line = rootidx - 1; //left inorder end 
         int lprs = prs + 1; //left preorder start
         int lpre = line - lins + lprs; //left preorder end 
         int rins = rootidx + 1; //right inorder start
         int rine = ine; //right inorder end 
         int rps = lpre + 1; //rightpreorder start
         int rpe = preE; //right preorder end 
         root.left = buildtreehelper(pre,in,lins,line,lprs,lpre);
         root.right = buildtreehelper(pre,in,rins,rine,rps,rpe);
         return root;
 
 
     }
}
