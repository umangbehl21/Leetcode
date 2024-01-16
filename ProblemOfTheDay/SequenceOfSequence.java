import java.util.ArrayList;

public class SequenceOfSequence {
    //User function Template for Java

class Solution{ //https://www.geeksforgeeks.org/problems/sequence-of-sequence1155/1
    static int count;
    static int numberSequence(int m, int n) 
    {
        // code here
        count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        numberSequenceHelper(1,n,m,list);
        return count;
    }
    static void numberSequenceHelper(int m,int n,int limit,ArrayList<Integer> list)
    {
        if(list.size() == n)
        {
            count++;
            return;
        }
        if(m > limit)
        {
            return;
        }
        list.add(m);
        numberSequenceHelper(m * 2,n,limit,list);
        list.remove(list.size()-1);
        numberSequenceHelper(m+1,n,limit,list);
        
    }
}
}
