package ProblemOfTheDay;

import java.util.PriorityQueue;

public class TheKweakestRowsInMatrix {
    class pair implements Comparable<pair> {
        int index;
        int count;
        pair(int index , int count)
        {
            this.index = index;
            this.count = count;
        }
        public int compareTo(pair o) //how two objects of pair class will be compared 
        {
            if(this.count < o.count)
            {
                return -1;
            }
            else if(this.count > o.count)
            {
                return 1;
            }
            else 
            {
                return this.index - o.index;
            }
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i = 0;i<mat.length;i++)
        {
            int count = 0;
            for(int j = 0;j<mat[0].length;j++)
            {
                if(mat[i][j] == 1)
                {
                    count++;
                }
            }
            pq.add(new pair(i,count));
        }
        int j = 0;
        int arr[] = new int[k];
        while(!pq.isEmpty())
        {
           if(k == 0)
           {
               break;
           }
           pair p = pq.remove();
           arr[j] = p.index;
           j++;
           k--;
        }
        return arr;
    }
}
