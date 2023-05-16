package BinaryTrees.Traversals;
import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class pair
{
    Node root;
    int lineno;
    public pair(int lineno,Node root)
    {
        this.lineno = lineno;
        this.root = root;
    }
}
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        Map<Integer,Integer> map = new TreeMap<>(); //treemap stores the nodes in ascending order of their line number 
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0,root));
        while(!q.isEmpty())
        {
            pair front = q.remove();
            int lineno = front.lineno;
            Node node = front.root;
            if(!map.containsKey(lineno))
            {
                map.put(lineno,node.data);
            }
            if(node.left != null)
            {
                q.add(new pair(lineno - 1,node.left));
            }
            if(node.right != null)
            {
                q.add(new pair(lineno + 1,node.right));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
         for(Map.Entry<Integer,Integer> entry : map.entrySet())  //Map.Entry<> is an iterator used to iterate over map keys map.entryset() returns the set of the keys among values in our map 
         {
         ans.add(entry.getValue());
        }
        return ans;
        
    }
}