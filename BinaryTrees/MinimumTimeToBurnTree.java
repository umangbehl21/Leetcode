package BinaryTrees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumTimeToBurnTree {
     public static Node findtargetnode(Node root,int target)  //prerequisite is nodes at distance k from target same in this solution bfs is used as we know bfs gives the shortest path in terms of edges so applying bfs to tree like on undirected graph give us the minimum time to burn complete tree as bfs will cover all possible edges at a level and add it to queue
    {
        if(root == null || root.data == target) 
        {
            return root;
        }
        Node lans = findtargetnode(root.left,target);
        Node rans = findtargetnode(root.right,target);
        if(lans != null && lans.data == target)
        {
            return lans;
        }
        if(rans != null && rans.data == target)
        {
            return rans;
        }
        else 
        return null;
        
    }
    public static int minTime(Node root, int target) 
    {
       HashMap<Node,Node> pmap = new HashMap<>();
       parentchild(root,pmap);
       Queue<Node> q = new LinkedList<>();
       HashSet<Node> visited = new HashSet<>();
       Node targetNode = findtargetnode(root,target);
       q.add(targetNode);
       visited.add(targetNode);
       int level = 0;
       while(!q.isEmpty())
       {
           int size = q.size();
           for(int i = 0;i<size;i++)
           {
               Node front = q.remove();
               if(front.left != null && !visited.contains(front.left))
               {
                   q.add(front.left);
                   visited.add(front.left);
               }
               if(front.right != null && !visited.contains(front.right))
               {
                   q.add(front.right);
                   visited.add(front.right);
               }
               if(pmap.containsKey(front) && !visited.contains(pmap.get(front)))
               {
                   q.add(pmap.get(front));
                   visited.add(pmap.get(front));
                   
               }
           }
           
           level++;
       
       }
       return level - 1 ; //LEVEL-1 because in the end when a node donnot add any other node in queue as its left and right are null but level +1 is done which should not be done as it didn't set any new node to fire but when for loop terminate level++ was done so we return level - 1 
    }
    public static void parentchild(Node root,HashMap<Node,Node> pmap)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node front = q.remove();
            if(front.left != null)
            {
                pmap.put(front.left,front);
                q.add(front.left);
            }
            if(front.right != null)
            {
                pmap.put(front.right,front);
                q.add(front.right);
            }
            
        }
        
        
    }
}
