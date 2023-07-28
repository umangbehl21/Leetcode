package BinarySearchQuestions;

public class FindMinimumInRotatedSortedArray { //in rotated sorted array one half of array is always sorted 
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(nums[mid] >= nums[low])  //if mid element is greater than lower it means left half is sorted and its min element is first element of sorted part which is nums[low] so take min from min,nums[low] and search in right part
            {
                min = Math.min(min,nums[low]);
                low = mid + 1;
            }
            else  //if mid element is less than low element it means that right part is sorted and mid is the minimum element from the right sorted part so search in left part as it is unsorted 
            {
               min = Math.min(nums[mid],min);
               high = mid - 1;
            }
        }
        return min;
    }
}
