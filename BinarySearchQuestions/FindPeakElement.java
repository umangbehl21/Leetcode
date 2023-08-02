package BinarySearchQuestions;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) //if there is only single element it is peak as it is considered that -1 index or index out of bound of array length is -infinity 
        {
            return 0;
        }
        if(nums[0] > nums[1]) //if first element is greater than second element then it is peak as first element resides on 0 index and its left index -1 has -infinity so it is greater than left index and if it is greater than right index element it means it is peak
        {
            return 0;
        }
        if(nums[n-1] > nums[n-2]) //if last element is grater than second last it means it is peak as nth index is index out of bound which is -infinity so last element if it is greater than second last it is peak 
        {
            return n-1;
        }
        int low = 1; //for 0th and n-1th edge cases are handled above so there should not be any array index out of bound
        int high = n-2;
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) //if mid is greater than left and right 
            {
                return mid;
            }
            else if(nums[mid] > nums[mid - 1]) //increasing graph if left elements are increasing peak cannot be there example 1,2,3,4,5 here 1 to 5 is increasing peak cannot be there so it is in the right part of mid in this case peak is 5 
            {
                low = mid + 1;
            }
            else if(nums[mid] > nums[mid + 1]) //decreasing graph if right elements are decreasing then peak cannot be there 5,6,4,3,2,1 here mid is 2nd index 4 right element of 4 is in decreasing graph where peak can't exist so move to left 
            {
                high = mid - 1;
            }
            else //2,1,2 mid is 1st index element which is less than mid + 1 element and mid - 1 element then else if will not run else will run and we can either do high = mid - 1 or low = mid + 1 as on either side there is peak 
            {
                high = mid - 1;
            }            
        }
        return -1;
    }
}
