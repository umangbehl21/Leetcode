package BinaryTrees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFSBinaryTree {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int infected = 0;
    public int amountOfTime(TreeNode root, int start) {
        int max = findmaxval(root);
        ArrayList<Integer> graph[] = new ArrayList[max+1];
        for(int i = 0;i<graph.length;i++)
        {
            graph[i] = new ArrayList<>();
        }
        makegraph(root,graph);
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        q.add(start);
        int size = q.size();
        while(!q.isEmpty())
        {
            int node = q.remove();
            size--;
            vis.add(node);
            for(int i = 0;i<graph[node].size();i++)
            {
                if(!vis.contains(graph[node].get(i)))
                q.add(graph[node].get(i));
            }
            if(size == 0)
            {
                infected++;
                size = q.size();
            }

        }
        return infected - 1;
    }
    
    public void makegraph(TreeNode root,ArrayList<Integer> graph[])
    {
        if(root == null)
        {
            return;
        }
        if(root.left != null)
        {
            graph[root.val].add(root.left.val);
            graph[root.left.val].add(root.val);
        }
        if(root.right != null)
        {
            graph[root.val].add(root.right.val);
            graph[root.right.val].add(root.val);
        }
        makegraph(root.left,graph); 
        makegraph(root.right,graph);

    }
    public int findmaxval(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int max = 0;
        if(root.val > max)
        {
            max = root.val;
        }
        int lans = findmaxval(root.left);
        int rans = findmaxval(root.right);
        max = Math.max(max,Math.max(lans,rans));
        return max;
    }
}
}
