package BinaryTrees.Traversals;
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Triplet
{
    TreeNode node;
    int row;
    int col;
    public Triplet(TreeNode node,int col,int row)
    {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(root,0,0));
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>(); 
        while(!q.isEmpty())
        {
           Triplet nodeinfo = q.remove();
           TreeNode node = nodeinfo.node;
           int col = nodeinfo.col;
           int row = nodeinfo.row;
           if(!map.containsKey(col))
           {
               map.put(col,new TreeMap<>());
           }
           if(!map.get(col).containsKey(row))
            {
               map.get(col).put(row,new PriorityQueue<Integer>());
            }
            map.get(col).get(row).add(node.val);
            if(node.left != null)
            {
                q.add(new Triplet(node.left,col-1,row+1));
            }
            if(node.right != null)
            {
                q.add(new Triplet(node.right,col+1,row+1));
            }
            
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> p : map.values()) //by this we get internal map of integer,priority queue
        {
            ans.add(new ArrayList<Integer>());
            for(PriorityQueue<Integer> pq : p.values())
            {
                while(!pq.isEmpty())
                {
                    ans.get(ans.size()-1).add(pq.remove());  //as we are adding arraylist at the end before the loop if we add first arraylist size will be 1 but it will on 0th index of ans that is why to get the arraylist we have to do ans.get(ans.size()-1)
                }
            }
        }
        return ans;
    }
}