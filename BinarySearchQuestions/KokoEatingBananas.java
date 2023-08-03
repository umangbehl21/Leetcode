package BinarySearchQuestions;

public class KokoEatingBananas { // min bananas koko have to eat in one hour to eat all piles in h hours
    public int FindMax(int piles[])
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<piles.length;i++)
        {
            if(piles[i] > max)
            {
                max = piles[i];
            }
        }
        return max;
    }
    public int minEatingSpeed(int[] piles, int h) { //h is the time in hours which koko have to eat all piles of banana
        int max = FindMax(piles);
        int low = 1;  //low to high is our range to binary search as if there is a pile which have maximum bananas among all piles example 10,20,30 and h = 3 then koko must have to eat minimum 30 bananas in one hour that is why range is from 1 to maximum in array as in the worst case koko have to eat minimum 30 bananas in one hour so 1 to max range 
        int high = max;
        int k = 0;
        while(low <= high)
        {
            int mid = (low + high)/2;
            boolean check = Check_If_Koko_Can_EatAll_PilesOfBananas_AtTime(piles,mid,h); 
            if(check == true)  //check equals to true means that time taken by koko to eat all piles of bananas is less or equal to the total hours that koko can take to eat all piles of bananas i.e totalhours <= h so we have to do mid - 1
            {
                k = mid;
                high = mid - 1;
            }
            else  //else check equal to false means time taken by koko is more than koko is allowed to take to so increase low to mid+1 so next mid is larger than current mid and koko will be able to eat more in one hour
            {
                low = mid + 1;
            }

        }
        return k; 
    }
    public boolean Check_If_Koko_Can_EatAll_PilesOfBananas_AtTime(int piles[],int Bph,int h) //Bph is banana eaten by koko per hour 
    {
        long totalhours = 0;
        for(int i = 0;i< piles.length;i++)
        {
            totalhours += (int)Math.ceil((double)piles[i]/Bph);  
            if(totalhours > h) //if total hours becomes  greater than the hours in which koko can eat bananas then return false 
              return false;
        }
        return true;
    }
}
