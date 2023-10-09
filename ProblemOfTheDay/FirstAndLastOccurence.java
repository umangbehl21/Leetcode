package ProblemOfTheDay;

public class FirstAndLastOccurence //of an integer
 {
        public int[] searchRange(int[] nums, int target) {
            int arr[] = {-1,-1};
            int start = 0;
            int end = nums.length-1;
            while(start <= end)
            {
                int mid = (start + end)/2;
                if(nums[mid] == target)
                {
                    arr[0] = mid;
                    end = mid - 1;
                }
                else if(nums[mid] < target)
                {
                    start = mid + 1;
                }
                else 
                {
                    end = mid - 1;
                }
            }
                start = 0;
                end = nums.length-1;
                 while(start <= end)
                {
                int mid = (start + end)/2;
                if(nums[mid] == target)
                {
                    arr[1] = mid;
                    start = mid + 1;
                }
                else if(nums[mid] < target)
                {
                    start = mid + 1;
                }
                else 
                {
                    end = mid - 1;
                }
            }
            return arr;
    
        }
}
