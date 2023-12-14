package ContestProblems;

public class CountSubarraysWhereMaxElementAppearsKtimes {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++)
        {   
            max = Math.max(max,nums[i]);
        } 
        int i = 0;
        int j = 0;
        int count = 0;
        long total = 0;
        
            while(j< nums.length)
            {
                if(nums[j] == max)
                {
                    count++;
                }
                if(count >= k)
                {
                    while(count >= k)
                    {
                       total += nums.length - j;
                       if(nums[i] == max)
                       {
                         count--;
                       }
                        i++;
                    }
                }
                j++;
            }
            return total;
    }
}
