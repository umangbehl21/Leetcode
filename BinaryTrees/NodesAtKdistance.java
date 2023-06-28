package BinaryTrees;
import java.util.*;
public class NodesAtKdistance // nodes at distance k from target node 
{
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) { //approach is to perform bfs on tree like an undirected graph and add upward parent node, left node , right node and consider these 3 nodes as one level or one distance away 
        HashMap<TreeNode,TreeNode> pmap = new HashMap<>();
         pointertoparent(root,pmap);
         HashMap<TreeNode,Boolean> visited = new HashMap<>();
         Queue<TreeNode> q = new LinkedList<>();
         q.add(target);
         visited.put(target,true);
         int level = 0; 
         while(!q.isEmpty())
         { 
             int size = q.size();
             if(level == k)
             {
                 break;
             }
             level++;
             for(int i = 0;i<size;i++)
             {
             TreeNode front = q.remove();
             if(front.left != null && !visited.containsKey(front.left)) 
             {
                 q.add(front.left);
                 visited.put(front.left,true);
             }
             if(front.right != null && !visited.containsKey(front.right)) //if right node is not null and rightnode is not already visited or present in the queue then mark it visited and add it in queue 
             {
                 q.add(front.right);
                 visited.put(front.right,true);
             }
             if(pmap.containsKey(front) && !visited.containsKey(pmap.get(front)))  //if there exists a parent for current node and it is not visited before 
             {
                 q.add(pmap.get(front));
                 visited.put(pmap.get(front),true);
             }
             }

         }
             List<Integer> ans = new ArrayList<>();
             while(!q.isEmpty())
             {
                 TreeNode front = q.remove();
                 ans.add(front.val);
             }
             return ans;
    }
    public void pointertoparent(TreeNode root,HashMap<TreeNode,TreeNode> pmap)
    {
       Queue<TreeNode> q = new LinkedList<TreeNode>();
       q.add(root);
       while(!q.isEmpty())
        {
            TreeNode current = q.remove();
            if(current.left != null)
            {
                pmap.put(current.left,current);
                q.add(current.left);
            }
            if(current.right != null)
            {
                pmap.put(current.right,current);
                q.add(current.right);
            }
        }

    }
}
