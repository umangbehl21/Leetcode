package BinarySearchQuestions;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(nums[mid] == target)
            {
                return mid;
            }
            //if left part is sorted
            else if(nums[mid] >= nums[low])  //<= because it will happen that nums[mid] and nums[low] belongs to same index element so it is important in that situation that this else if run in that case  
            {
                if(nums[low] <= target && target < nums[mid]) // if it lies then set high to mid - 1 as now we will search in left side only 
                {
                    high = mid - 1;
                }
                else  //else if target is not in range then we can discard this sorted left part as target is not in the sorted range search in right part
                {
                    low = mid + 1;  
                }
            }
            //if right part is sorted
            else if(nums[mid] <= nums[high]) //<= because it will happen that nums[mid] and nums[low] belongs to same index element so it is important in that situation that this else if run in that case 
            {
                if(nums[mid] < target && target <= nums[high])
                {
                    low = mid + 1; //search in right part
                }
                else 
                {
                    high = mid - 1;  //discard right part 
                }
            }
        }
            return -1;

    }
}
