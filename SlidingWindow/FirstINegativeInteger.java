package SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FirstINegativeInteger //in every window of size k 
{
     public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Queue<Long> q = new LinkedList<>();
        ArrayList<Long>list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(j < A.length)
        {
            if(A[j] < 0)
            {
                q.add(A[j]);
            } 
            // j -i + 1 is done as array has 0 based indexing 
            if((j - i + 1) == K) //if difference in i and j is equal to window size then its time to add the first negative integer of current window 
            {
                if(q.isEmpty()) //if queue is empty means there is no negative number in current window then add 0 for that window 
                {
                    long a = 0;
                    list.add(a);
                }
                else 
                {
                    list.add(q.peek()); //if queue is not empty then add only the front element of the queue as we have to add the first negative integer in every window of size k
                    if(A[i] == q.peek()) //now as we have added the front element it can happen that the current front element in queue is not included for the next window in the array if array is -1,2-3 and window size is 2 then second window will be of 2,-3 then -1 cannot become the answer of second window so we remove it 
                    {
                        q.remove();
                    }
                }
                i++; //after removing current front element we slide window to one step from begining 
            }
            j++; // we slide window to one step from the end
            
        }
        long ans[] = new long[list.size()];
        for(int k = 0;k < ans.length;k++)
        {
            ans[k] = list.get(k);
        }
        return ans;
    }
}
