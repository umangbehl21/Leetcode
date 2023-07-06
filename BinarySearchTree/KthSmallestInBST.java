package BinarySearchTree;
import java.util.*;
public class KthSmallestInBST { //meaning of finding kth smallest means kth maximum element in the group of k smallest elements (choto me se sbse bada)
     PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public int kthSmallest(TreeNode root, int k) {
        kthSmallestHelper(root,k);
        return pq.remove();
    }
    public void kthSmallestHelper(TreeNode root,int k)
    {
        if(root == null)
        {
            return;
        }
        if(pq.size() != k) //first we will add random k elements in priorit queue then we will check if upcoming elements are smaller than current peek in priority queue as we have to find kth smallest element we maintain k elements in pq at every moment 
        {
            pq.add(root.val);
        }
        else 
        {
            if(root.val < pq.peek())  //if current root is less than peek element of priorityqueue then add the smaller element because kth smallest means we will add all the consecutive smaller elements in priority queue and return the maximum of k smallest elements 
            {
                pq.remove();
                pq.add(root.val);
            }
        }
        kthSmallestHelper(root.left,k);
        kthSmallestHelper(root.right,k);

    }
}
