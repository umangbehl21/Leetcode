public class ConstructStringFromBinaryTree {

        public String tree2str(TreeNode root) {  //leetcode 606
            if(root == null)
            {
                return "";
            }
            String ls = tree2str(root.left);
            String rs = tree2str(root.right);
            if(ls == "" && rs == "")
            {
                return root.val + "";
            }
            else if(ls == "")
            {
                return root.val + "()" + "(" + rs + ")"; 
            }
            else if(rs == "")
            {
                return root.val + "(" + ls + ")";
            }
            else 
            {
                return root.val + "(" + ls + ")" + "(" + rs + ")";
            }
    
        }
    }
