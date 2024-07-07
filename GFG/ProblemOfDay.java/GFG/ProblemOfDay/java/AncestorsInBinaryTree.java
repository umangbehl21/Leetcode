import java.util.ArrayList;
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
public class AncestorsInBinaryTree {


        public ArrayList<Integer> Ancestors(Node root, int target) {
            // add your code here
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(-1);
            AncestorsFind(root,target,list);
            list.remove(list.size()-1);
            return list;
            
        }
        public boolean AncestorsFind(Node root,int target,ArrayList<Integer> list)
        {
            if(root == null)
            {
                return false;
            }
            
            if(root.data == target)
            {
                return true;
            }
            
            list.add(0,root.data);
            
            boolean lans = AncestorsFind(root.left,target,list);
            if(lans)
            {
                return true;
            }
            boolean rans = AncestorsFind(root.right,target,list);
            if(rans)
            {
                return true;
            }
            list.remove(0);
            return false;
            
        }
    }
