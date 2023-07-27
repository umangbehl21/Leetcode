package BinarySearchQuestions;

public class SearchInRotatedSortedArrayWithDuplicates {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(nums[mid] == target)
            {
                return true;
            }
            if(nums[mid] == nums[low] && nums[mid] == nums[high])
            {
                low++;
                high--;
                continue; //continue is importand as after shrinking first we have to check again if mid low and high are equal . while they are equal we can shrink array otherwise we will not be able to find a sorted half of array when we find a sorted half then only we can check if our target is in the range of that sorted half 
            }
           else if(nums[low] <= nums[mid])
            {
                if(nums[low] <= target && target < nums[mid])
                {
                    high = mid - 1;
                }
                else 
                {
                    low = mid + 1;
                }
            }
          else if(nums[mid] <= nums[high])
          {
              if(nums[mid] < target && target <= nums[high])
              {
                  low = mid + 1;
              }
              else 
              {
                  high = mid - 1;
              }
          }



        }
        return false;
    }
}
