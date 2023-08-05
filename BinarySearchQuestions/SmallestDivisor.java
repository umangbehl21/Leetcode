package BinarySearchQuestions;

public class SmallestDivisor {
    public int FindMax(int nums[])
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
    
    public int smallestDivisor(int[] nums, int threshold) { //find minimum number which when divided by all elements of the array one by one and result of division is added to sum i.e sum += element/number that sum should be less than or equal to threshold value 
        int low = 1;
        int high = FindMax(nums); 
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(isSumLessOrEqual(nums,mid,threshold) == true)
            {
                high = mid-1;
            }
            else 
            {
                low = mid + 1;
            }
        }
        return low;

    }
    public boolean isSumLessOrEqual(int nums[],int mid,int threshold)
    {
        int sum = 0;
        for(int i = 0;i<nums.length;i++)
        {
            sum += Math.ceil((double)nums[i]/mid);
        }
        if(sum <= threshold)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}
