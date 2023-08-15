package BinarySearchQuestions;

public class SplitArrayIntoKparts {
    public int findmax(int nums[])
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] > max)
            {
                max = nums[i];
            }
        }
        return max;
    }
    public int sumofnums(int nums[])
    {
        int sum = 0;
         for(int i = 0;i<nums.length;i++)
        {
             sum += nums[i];
        }
        return sum;
    }

    public int splitArray(int[] nums, int k) {
        int low = findmax(nums);
        int high = sumofnums(nums);
        while(low <= high)
        {
            int mid = (low + high)/2;
            if( isSumSufficient_ToDivideArrayInto_K_Subarray(nums, mid , k) > k)
            {
               low = mid + 1;
            }
            else 
            {
                high = mid - 1;
            }
        }
        return low;
    }
    public int isSumSufficient_ToDivideArrayInto_K_Subarray(int nums[],int limitofsum,int k)
    {
        int csum = 0;
        int subpartscount = 1;
        for(int i = 0;i<nums.length;i++)
        {
            if(csum + nums[i] <= limitofsum)
            {
                csum += nums[i];
            }
            else 
            {
                csum = nums[i];
                subpartscount++;
            }
        }
        return subpartscount;
    }
}
