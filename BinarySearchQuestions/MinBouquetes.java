package BinarySearchQuestions;

public class MinBouquetes {
    public int FindMax(int bloomDay[])
    {
        long max = Long.MIN_VALUE;
        for(int i = 0;i<bloomDay.length;i++)
        {
            if(bloomDay[i] > max)
            {
                max = bloomDay[i];
            }
        }
        return (int)max;
    }
       public int FindMin(int bloomDay[])
    {
        long min = Long.MAX_VALUE;
        for(int i = 0;i<bloomDay.length;i++)
        {
            if(bloomDay[i] < min)
            {
                min = bloomDay[i];
            }
        }
        return (int)min;
    }
    public int minDays(int[] bloomDay, int m, int k) {  //m is the number of bouquets that we have to make and k is number of adjacent flowers required to make a bouquet
        long reqelems = (long)m * (long)k; 
        if(bloomDay.length < reqelems )
        {
            return -1;
        }
        int min = FindMin(bloomDay);
        int max = FindMax(bloomDay);
        int low = min;
        int high = max;
        int mid = 0;
        while(low <= high)
        {
            mid = (low + high)/2;
            if( ispossible_to_make_m_bouquets(bloomDay,m,k,mid) == true)
            {
                high = mid - 1;
            }
            else 
            {
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean ispossible_to_make_m_bouquets(int bloomDay[],int m,int k,int day) //day is the number of days passed within which flowers bloom in garden 
    {
        int count = 0;
        int bcount = 0;
        for(int i = 0;i<bloomDay.length;i++)
        {
            if(bloomDay[i] <= day)
            {
                count++;
            }
            else 
            {
                bcount += count/k;
                count = 0;
            }
        }
        bcount += (count/k); 
        if(bcount >= m)
        {
            return true;
        }
        else 
        {
            return false;
        }

    }
}
