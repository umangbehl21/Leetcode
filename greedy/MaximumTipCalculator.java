package greedy;
import java.util.PriorityQueue;

class Solution {
    static class pair implements Comparable<pair>
    {
        int abs = 0;
        int first = 0;
        int second = 0;
        public pair(int abs,int first,int second)
        {
            this.abs = abs;
            this.first = first;
            this.second = second;
        }
        public int compareTo(pair obj)
        {
            if(this.abs > obj.abs)  //sorting in descending order on the basis of absolute difference value as more the absolute difference signifies or tell to choose a specific tip as choosing the lesser tip will reduce overall total see in the last of this code the comments explain in more detail 
            {
                return -1;
            }
            else if(this.abs < obj.abs) 
                return 1;
            else 
                return 0;
        }
    }
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        // code here
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i = 0;i<arr.length;i++)
        {
            int abs = Math.abs(arr[i] - brr[i]);
            pq.add(new pair(abs,arr[i],brr[i]));
        }
        long total = 0;
        while(!pq.isEmpty() && (x > 0 || y > 0))
        {
            pair p = pq.remove();
             if (p.first > p.second) {  //if first tip is greater than second and x is greater than 0 means we can use current waiter then add first to total if x is 0 we cant use first waiter to gain tip add second 
                if (x > 0) {
                    total += p.first;
                    x--;
                } else {
                    total += p.second;
                    y--;
                }
            } else {
                if (y > 0) {
                    total += p.second;
                    y--;
                } else {
                    total += p.first;
                    x--;
                }
            }
            
        }
        return total;
        
    }   
}

// Detailed Explanation:
// Prioritize Largest Differences:

// When the absolute difference (abs) between the two tips is large, it means that choosing the smaller tip would lead to a significant reduction in the total possible tips.
// Therefore, by sorting in descending order of abs, we prioritize the decisions that have the most impact on the total tips first.
// Greedy Choice:

// By addressing the largest differences first, the algorithm can make the best possible decision at each step.
// For each pair, you choose the higher tip (from the available choices x or y) to maximize the current contribution to the total tips.
// Managing Constraints:

// The constraints x and y ensure that the choice is within the allowed limits for each type of tip.
// If x runs out, the algorithm will choose the second tip (brr), and vice versa.
