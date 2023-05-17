package BinaryTrees;
import java.util.*;
public class RootToNodePath {
        public int[] solve(TreeNode A, int B) {
            if(A.left == null && A.right == null)
            {
                int ans[] = {A.val};
                return ans;
            }
            Stack<Integer> st = new Stack<>();
            boolean p = rootToNodePath(A,st,B);
            int ans[] = new int[st.size()];
            for(int i = 0;i<ans.length;i++)
            {
                ans[i] = st.pop();
            }
            return ans;
        }
        public boolean rootToNodePath(TreeNode root,Stack<Integer> st,int tofind)
        {
            if(root == null)
            {
                return false;
            }
            if(root.val == tofind)
            {
                st.add(root.val);
                return true;
            }
            boolean lans = rootToNodePath(root.left,st,tofind);
            if(lans)
            {
                st.add(root.val);
                return true;
            }
            boolean rans = rootToNodePath(root.right,st,tofind);
            if(rans)
            {
                st.add(root.val);
                return true;
            }
            return false;
        }
    }

