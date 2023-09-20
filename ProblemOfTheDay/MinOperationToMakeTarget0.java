package ProblemOfTheDay;

public class MinOperationToMakeTarget0 { //sliding window concept to find longest sum subarray whose length will be equal to (totalsum of array - target) which will help us to find the length of elements used to make target
    public int minOperations(int[] nums, int x) {
        int tsum = 0;
        int count = 0; //count for checking how many numbers are greater than x if count and length of array is same it means all numbers are greater and subtracting any of them from x will led to negative value
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] > x)
            {
                count++;
            }
            tsum += nums[i];
        }
        if(count == nums.length || tsum < x) return -1;      
        int rsum = tsum - x; //remaning sum it is the total array sum - target if we know how many number of elements are required to make sum in which target is excluded and subtracting this number from total array length can give us the number of elements required to make actual target x
        if(x == rsum) //if target is 50 we have to reduce 50 to 0 and array is {25,25} now we have to remove all elements in the array to bring target to 0 
        {
            return nums.length;
        }
        int right = 0;
        int left = 0;
        int maxlen = Integer.MIN_VALUE;
        int csum = 0;
        while(right < nums.length && left <= right)
        {
            csum += nums[right];
            while(csum > rsum)
            {
                csum = csum - nums[left];
                left++;
            }
            if(csum == rsum)
            {
                maxlen = Math.max(maxlen,right - left + 1);
            }
            right++;

        }
        return nums.length - maxlen;
    }
}
