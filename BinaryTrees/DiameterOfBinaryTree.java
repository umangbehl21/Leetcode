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
 
class DiameterOfBinaryTree {
    class pair 
    {
        int diameter;
        int height;
        public pair(int diameter,int height)
        {
            this.diameter = diameter;
            this.height = height;
        }
    }
     public int diameterOfBinaryTree(TreeNode root) {
         pair td = diameterOfBinaryTreeHelp(root);
         return td.diameter;
     }
    public pair diameterOfBinaryTreeHelp(TreeNode root) {  //diameter can be find through 3 options one is from left height + right height , second is left diameter , third is from right diameter  
        if(root == null)
        {
            return new pair(0,0);  
        }
        pair lst = diameterOfBinaryTreeHelp(root.left);
        pair rst = diameterOfBinaryTreeHelp(root.right);
        int th = Math.max(lst.height,rst.height) + 1;
        int td =   Math.max(lst.height + rst.height,Math.max(lst.diameter,rst.diameter)); 
        return new pair(td,th);

    }
}