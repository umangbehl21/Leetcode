package SlidingWindow;

public class MaximumLengthSubarrayWhichHaveSumK {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        int i = 0;
        int j = 0;
        long csum = 0;
        int count = 0;
        while(j < a.length && i < a.length)
        {
                csum += a[j];
                while(i<j && csum > k)
                {
                  csum = csum - a[i];
                  i++;
                }
                if(csum == k)
                {
                  count = Math.max(count,j-i+1);
                }
                j++;
        }
        return count;

    }
}
