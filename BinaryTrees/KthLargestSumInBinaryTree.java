package BinaryTrees;

import java.util.*;

public class KthLargestSumInBinaryTree {
    class Solution {
        public long kthLargestLevelSum(TreeNode root, int k) {
            ArrayList<Long> list = new ArrayList<>();
            int noninl = 0; //total number of nodes in a level
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            list.add((long)root.val);
            noninl++;
            long sum = 0;
            while(!q.isEmpty())  
            {
                TreeNode front = q.remove();
                noninl--;
                if(front.left != null)
                {
                    q.add(front.left);
                    sum += front.left.val;
                }
                if(front.right != null)
                {
                    q.add(front.right);
                    sum += front.right.val;
                }
                if(noninl == 0)  
                {
                    if(q.size() == 0)
                    {
                        break;
                    }
                    list.add(sum);
                    noninl = q.size();  
                    sum = 0;
                }
    
            }
            if(k > list.size())
            {
                return -1;
            }
            PriorityQueue<Long> pq = new PriorityQueue<>();
            int it = 0;
            while(pq.size() < k)
            {
                pq.add(list.get(it));
                it++;
            }
            while(it < list.size())
            {
                if(list.get(it) > pq.peek())
                {
                    pq.remove();
                    pq.add(list.get(it));
                }
                it++;
            }
            return pq.peek();
        }
    }
}
