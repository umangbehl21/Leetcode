package BinarySearchTree;
class RecoverBST
{
    private TreeNode prev;
    private TreeNode first;
    private TreeNode mid;
    private TreeNode last;
    public void recoverTree(TreeNode root) { //recover original bst by swapping the two nodes at wrong positions 
        prev = null;
        first = null;
        mid = null;
        last = null;
        inorder(root);
        if(first != null && last != null)
        {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else if(first != null && mid != null) 
        {
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
    }
    public void inorder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left);
        if(prev != null && root.val < prev.val)
        {
            if(first == null) //on first violation the previous root in inorder is first and mid is set to current root we have to store mid because it might happen that these two are only need to be swapped and we donnot know that in future a violation will occur or not
            {
                first = prev;
                mid = root;
            }
            else //if there is second violation mark current root node as last 
            {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}