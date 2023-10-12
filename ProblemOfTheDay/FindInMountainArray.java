package ProblemOfTheDay;


    class Solution {
        public int findInMountainArray(int target, MountainArray Arr) {
            int peek = findpeek(Arr);
            if(Arr.get(peek) == target)
            {
                return peek;
            }
            int low = 0;
            int high = peek-1;
            while(low <= high)
            {
                int mid = low + (high-low)/2;
                int mval = Arr.get(mid);
                if(mval == target)
                {
                    return mid;
                }
                else if(mval > target)
                {
                    high = mid - 1;
                }
                else 
                {
                    low = mid + 1;
                }
            }
            low = peek + 1;
            high = Arr.length() - 1;
            while(low <= high)
            {
                int mid = low + (high-low)/2;
                int mval = Arr.get(mid);
                if(mval == target)
                {
                    return mid;
                }
                else if(mval < target)
                {
                    high = mid - 1;
                }
                else 
                {
                    low = mid + 1;
                }
            }
            return -1;
        }
        public int findpeek(MountainArray Arr)
        {
                 int low = 0 ;
                 int high = Arr.length() - 1;
                 while(low <= high)
                 {
                     int mid = low + (high-low)/2;
                     int mval = Arr.get(mid);
                     if(mid > 0 && mval > Arr.get(mid - 1) && mval > Arr.get(mid + 1))
                     {
                        return mid;
                     }
                     else if(mid > 0 && mval < Arr.get(mid-1))
                     {
                         high = mid - 1;
                     }
                     else 
                     {
                         low = mid + 1;
                     }
                 }
                 return -1;
                  
            } 
    
        }
    
}
