package SlidingWindow;

import java.util.ArrayList;

public class MaximumSumsubArray {
        static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int i = 0;
        int j = 0;
        long csum = 0;
        long max = Integer.MIN_VALUE;
        while(j < K)  //creating a window
        {
            csum += Arr.get(j);
            j++;
        }
        if(csum > max)
        {
            max = csum;
        }
        while(j<Arr.size()) 
        {
            csum = csum - Arr.get(i); //then subtracting ith element from current sum
            csum = csum + Arr.get(j); //adding jth element in current sum 
            if(csum > max) //then comapring current sum with overall max 
            {
                max = csum;
            }
            i++;
            j++;
        }
        return max;
      }
}
