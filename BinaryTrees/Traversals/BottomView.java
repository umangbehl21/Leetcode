package BinaryTrees.Traversals;
import java.util.*;
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
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root)
    {
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0,root));
        while(!q.isEmpty())
        {
            pair front = q.remove();
            Node node = front.root;
            int lineno = front.lineno;
            map.put(lineno,node.data);  //as we have to add the last node that appears laast on the column we will keep on overriding the current node values added with that line no until the last node at last level is added
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
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
