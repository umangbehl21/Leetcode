package BinarySearchQuestions;

import java.util.Arrays;

public class AggresiveCows { //minimum distance between any two of the cows should be maximum and all cows must be placed to its respective stalls maintaining current maximum distance 
     public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls); //sorting in ascending order can only make distance between two cows positive otherwise if elments are unsorted distance can be negative between them 
        int len = stalls.length;
        int low = 1;
        int high = stalls[len - 1] - stalls[0]; //if there are two cows then maximum distance between two of them can go till the difference of maximum element - minimum element of array example 1,2,3,4,5 and cows = 2 then max distance between two cows can go till 5 - 1 = 4 so our range end on difference between max - min elements
        while(low <= high)
        {
            int mid = (low + high)/2;
            boolean check = canWePlaceCows(stalls,mid,k);
            if(check) //if check true then we need to go right as we have to make minimum distance between any two cows as maximum so if maintaining current distance we can place all cows then increase distance  
            {
                low = mid + 1;
            }
            else  //else if for current mid all cows cannot be placed maintaining the minimum distance between them of mid then go to left so that we can place all cows 
            {
                high = mid - 1;
            }
        }
        return high;
        
    }
    public static boolean canWePlaceCows(int stalls[],int distance,int k)
    {
        int last = stalls[0]; //currently we place first cow at first stall of array 
        int cowsplaced = 1; //as one cow is placed we intialise cowplaced count to 1
        for(int i = 1;i<stalls.length;i++)
        {
            if(stalls[i] - last >= distance)
            {
                last = stalls[i];
                cowsplaced++;
            }
            if(cowsplaced == k)
            {
                return true;
            }
        }
        return false;
        
    }
}
