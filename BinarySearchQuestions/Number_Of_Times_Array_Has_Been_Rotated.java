package BinarySearchQuestions;

public class Number_Of_Times_Array_Has_Been_Rotated {
    public static int findKRotation(int []arr){
        int low = 0;
        int high = arr.length - 1;
        int minindex = Integer.MAX_VALUE; //index of minimum element in the array is answer to this question because all the elements which are rotated are shifted behind this minimum index more elements are rotated the minimum element is also shifted ahead and all greater numbers are behind it so minimmum index is the number of times array is rotated example 4,5,1,2,3 here 4 and 5 are rotated and minimum element is shifted ahead to the count of rotated element 
        int min = Integer.MAX_VALUE;
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(arr[mid] >= arr[low]) //if mid element is greater than or equal to arr[low] element which is initially 0 indexed element it will mean that left part to the mid is sorted and minimum lement in the sorted half is always on the begining index which is 0 so we discard left part as we now know its minimum element index 
            {
                if(arr[low] < min) //if current element is less than overall min then update min and minindex also 
                {
                  min = arr[low];
                  minindex = low;
                }                
                low = mid + 1;
            }
            else  //if mid element is less than 0th index element it means left part to the mid is not sorted and right part is sorted because in rotated array one half is always sorted if right part is sorted minimum element now known to us is the mid element so we discard right part and find minimmum in left part 
            {
                if(arr[mid] < min)
                {
                    min = arr[mid];
                    minindex = mid;
                }
                high = mid - 1;

            }

        }
        return minindex;
    }
}
