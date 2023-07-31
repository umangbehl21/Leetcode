package BinarySearchQuestions;

public class FindSingleNumberInSorted {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1) //edge case of single element
        { 
            return nums[0];
        }
        if(nums[0] != nums[1]) //edge cases of 0th and n-1 element 
        {
            return nums[0];
        }
        if(nums[n-1] != nums[n-2])
        {
            return nums[n-1];
        }
        int low = 1;
        int high = n-2;
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid + 1])
            {
                return nums[mid];
            }
            if(mid % 2 == 0 && nums[mid] == nums[mid+1] || mid % 2 != 0 && nums[mid - 1] == nums[mid]) //if mid element is at even index and its next odd index element is same as mid element or mid is at odd index and it is equal to previous even index element i.e mid == mid-1 it means that the left part of array donnot contain single element because whenever single element comes it breaks the pattern of even odd and change it to odd even example 1,1,2,2,3,4,4,5,5,6,6 here 1,1 is on (0,1) index which is even odd and 2,2 is on (2,3) index which is even odd but when 3 which is single element it arrives after 3 pattern change to odd even 4,4 is on (5,6) index which is odd,even 5,5 is on (7,8) which is again odd even 
            {
                low = mid + 1;
            }
            else //else if mid is appearing on the odd index and it is equal to next even index element i.e mid == mid + 1 making pattern odd even which means that single element is on the left part of this mid so discard right part  
            {
                high = mid - 1;
            }

        }
        return -1;
    
    }
}
