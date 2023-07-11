package BinarySearchTree;

import java.util.Stack;

class BSTIterator {  //this bst iterator iterate over trees inorder average of o(1) time is taken while doing operations and at anytime only o(h) space is used which make it a optimise solution as if we iterate by storing original inorder array it is o(n) space

    private Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushall(root);
    }
    
    public int next() { //return next element of inorder traversal 
        TreeNode temp = st.pop();
        pushall(temp.right); //before returning the current element we add its right subtree 
        return temp.val;
    }
    
    public boolean hasNext() { //if stack is not empty means nodes are there 
        if(!st.isEmpty())
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    private void pushall(TreeNode root) 
    {
        while(root != null) //continue adding left nodes as they are first in the inorder then add right nodes of current left node present in the stack as right node are after left nodes in inorder 
        {
            st.push(root);
            root = root.left;
        }
    }
}

