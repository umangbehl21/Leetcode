package BinaryTrees;
import java.util.*;
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

class MaximumWidthOfBinaryTree {
    class pair
    {
        int nodeId;
        TreeNode node;
        public pair(TreeNode node,int nodeId)
        {
            this.node = node;
            this.nodeId = nodeId;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {    //basic approach is to number or give index id to the nodes according to the order in which they appear in a level if a level has 4 nodes then first node will have 1 id and last node will have 4 id
        Queue<pair> pendingnodes = new LinkedList<>();
        pendingnodes.add(new pair(root,0));
        int ans = 0;
        while(!pendingnodes.isEmpty())
        {
            int MinId = pendingnodes.peek().nodeId;
            int first=0,last=0;
            int size = pendingnodes.size();
            for(int i = 0;i<size;i++)
            {
                int curId = pendingnodes.peek().nodeId - MinId; //the basis on which next level node ID are calculated to avoid overflow we want every level indexes to start from 1...... to no of nodes
                if(i == 0) 
                    first = curId;
                if(i == size - 1)
                    last = curId;
                pair p1 = pendingnodes.remove();
                if(p1.node.left != null)
                {
                    pendingnodes.add(new pair(p1.node.left,2 * curId + 1)); 
                }
                if(p1.node.right != null)
                {
                    pendingnodes.add(new pair(p1.node.right,2 * curId + 2));
                }
            }
            ans =  Math.max(ans,last - first + 1);  //distance between the last node - first node + 1 is the number of nodes in between them 
        }
        return ans;
    }

}