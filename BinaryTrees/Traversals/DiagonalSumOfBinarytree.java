public class DiagonalSumOfBinarytree {
    public static ArrayList <Integer> diagonalSum(Node root) 
    {
        // code here.
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int size = q.size();
        while(!q.isEmpty()) 
        {
            while(size-- > 0) //traverse on components 
            {
                Node front = q.remove();
                while(front != null) //traverse on the diagonal 
                {
                    sum += front.data;
                    if(front.left != null) //for next diagonal 
                    {
                        q.add(front.left);
                    }
                    front = front.right;
                }
                
            }
            list.add(sum);
            sum = 0;
            size = q.size();
            
        }
        return list;
        
    }
}
