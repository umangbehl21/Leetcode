package BinarySearchQuestions;

public class LeastCarryingCapacity { // least capacity means ship has to carry least weight every day and still it complete transport of all the weights until the last day 
    public int FindMax(int weights[])
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<weights.length;i++)
        {
            if(weights[i] > max)
            {
                max = weights[i];
            }
        }
        return max;
    }
    public int sumOfWeights(int weights[])
    {
        int sum = 0;
        for(int i = 0;i<weights.length;i++)
        {
            sum += weights[i];
        }
        return sum;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = FindMax(weights); //low starts with the maximum element in the array because suppose maximum is 10 but ship has capacity of 8 now how ship will carry weight of 10 so minimum weight ship must carry is maximum element in the array 
        int high = sumOfWeights(weights); //high ends at sum of all elements in the array because suppose that we have to transport all the weights or elements in the array in one day so ship has to carry all weight so its least capacity will be sum of all elements 
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(CanShipFulfillWithCurrentCapacity(weights,days,mid)) //when ship can transport all weights within days by using current capacity decided through mid but it may happen that current capacity is not least capacity because it might happen mid is large number and days which were given to transport all weights were 5 but because mid was a greater number capacity of ship was large so it took only 2 days so we have to find least capacity such that ship have some weight to carry until the 5th day 
            {
                high = mid - 1;
            }
            else //if current capacity decided through mid is less and ship is not able to transport all weight within given days tben increase low from current mid + 1 so that next time mid is a greater number and so is capacity
            {
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean CanShipFulfillWithCurrentCapacity(int weights[],int days,int capacity)
    {
        int daycount = 1; 
        int wsum = 0; //weight sum
        for(int i = 0;i<weights.length;i++)
        {
            if(weights[i] + wsum <= capacity) //if weight sum till now + current weight is still less than the capacity ship has then add current weight in weight sum as we will fill the ship until weight didn't become greater than capacity ship has so that we can take maximum on a day 
            {
                wsum += weights[i];
            }
            else 
            {
                daycount++; // will pick this weight on next day 
                wsum = weights[i]; //new weight sum is assigned old is dispatched by ship on previous day 
            }
        }
        if(daycount <= days) //if daycount taken by ship to transport all the weights according to the capacity passed to function is less than or equal to the days that ship has to take then return true
        {
            return true;
        }
        else //else if days taken by ship to transport all the weights according to the capacity passed to the function is more than the days that ship should have taken then return false
        {
            return false;
        }


    }
}
