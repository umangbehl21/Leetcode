package BinaryTrees;
class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;     
    }
  }
   class IsBinaryTreeBalanced {
       class pair
       {
           boolean isbal = false;
           int height = 0;
           public pair(int height,boolean isbal)
           {
               this.height = height;
               this.isbal = isbal;
           }
       }
       public boolean isBalanced(TreeNode root) {
           pair tb = isBalancedHelp(root);
           if(tb.isbal == false)
           {
               return false;
           }
           else 
           {
               return true;
           }
       }
       public pair isBalancedHelp(TreeNode root)
       {
           if(root == null)
           {
               pair p = new pair(0,true);
               return p;
           }
           pair lh = isBalancedHelp(root.left);
           if(!lh.isbal)  //as soon as a node finds that its left subtree is unbalanced it returns false and higher nodes also returns false because for tree to balance all left subtree should be balance as well as all right subtree should be balanced
           {
               return new pair(lh.height,false);
           }
           pair rh = isBalancedHelp(root.right);
            if(!rh.isbal)
           {
               return new pair(rh.height,false);
           }
           int th = Math.max(lh.height,rh.height) + 1;
           boolean tb;
           if(Math.abs(lh.height - rh.height) > 1)
           {
               tb = false;
           }
           else
           {
              tb = true;
           }
           pair p = new pair(th,tb);
           return p;
   
           
       }
   
   
       
   }
